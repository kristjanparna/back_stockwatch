package ee.valiit.stockwatch.domain.portfolio;


import ee.valiit.stockwatch.business.portfolio.PortfolioRequest;
import ee.valiit.stockwatch.business.portfolio.PortfolioResponse;
import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentResponse;
import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentService;
import ee.valiit.stockwatch.domain.transaction.Transaction;
import ee.valiit.stockwatch.domain.transaction.TransactionMapper;
import ee.valiit.stockwatch.domain.transaction.TransactionRepository;
import ee.valiit.stockwatch.domain.user.user.User;
import ee.valiit.stockwatch.domain.user.user.UserService;
import ee.valiit.stockwatch.infrastructure.exception.BusinessException;
import ee.valiit.stockwatch.validation.StockwatchError;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.valueOf;

@Service
public class PortfolioService {

    @Resource
    private InstrumentService instrumentService;

    @Resource
    private UserService userService;

    @Resource
    private PortfolioMapper portfolioMapper;

    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private PortfolioRepository portfolioRepository;

    @Resource
    private TransactionRepository transactionRepository;

    public void addInstrumentToPortfolio(PortfolioRequest portfolioRequest) {
        Instrument instrument = checkIfInstrumentExists(portfolioRequest);
        User user = userService.findUserById(portfolioRequest.getUserId());
        Portfolio portfolio = portfolioMapper.portfolioRequestToPortfolio(portfolioRequest);
        portfolio.setInstrument(instrument);
        portfolio.setUser(user);
        portfolioRepository.save(portfolio);
        addTransactionHistory(portfolioRequest, portfolio);
    }

    public void reduceInPortfolio(PortfolioRequest portfolioRequest) {
        Instrument instrument = instrumentService.findInstrumentByTicker(portfolioRequest.getTicker());
        List<Portfolio> portfoliosByInstrument = portfolioRepository.findBy(portfolioRequest.getUserId(), instrument.getId());

        Integer totalInstrumentAmount = 0;
        for (Portfolio portfolio : portfoliosByInstrument) {
            Integer amount = portfolio.getAmount();
            totalInstrumentAmount += amount;
        }

        if (totalInstrumentAmount < portfolioRequest.getAmount()) {
            throw new BusinessException(StockwatchError.NOT_ENOUGH_INSTRUMENTS.getMessage(), StockwatchError.NOT_ENOUGH_INSTRUMENTS.getErrorCode());
        } else {
            addInstrumentToPortfolio(portfolioRequest);
        }
    }

    private void addTransactionHistory(PortfolioRequest portfolioRequest, Portfolio portfolio) {
        Transaction transaction = transactionMapper.portfolioRequestToTransaction(portfolioRequest);
        transaction.setPortfolio(portfolio);
        transactionRepository.save(transaction);
    }

    private Instrument checkIfInstrumentExists(PortfolioRequest portfolioRequest) {
        List<Instrument> allInstruments = instrumentService.findAllInstruments();
        for (Instrument existingInstrument : allInstruments) {
            if (existingInstrument.getTicker().equals(portfolioRequest.getTicker())) {
                return existingInstrument;
            }
        }
        return addInstrument(portfolioRequest);
    }

    private Instrument addInstrument(PortfolioRequest portfolioRequest) {
        instrumentService.addNewInstrument(portfolioRequest.getTicker(), portfolioRequest.getShortName());
        return instrumentService.findInstrumentByTicker(portfolioRequest.getTicker());
    }


    public List<PortfolioResponse> getPortfolioInformation(Integer userId) {
        List<Portfolio> userPortfolios = portfolioRepository.findByUserId(userId); // Leiab kõik selle kasutaja portfellid

        // List kõikidest vastustest, mis tuleb Fronti saata
        List<PortfolioResponse> responseList = getResponses(userPortfolios);

        // List unikaalsetest instrumentidest, mis on selle kasutaja portfellis
        List<Instrument> instruments = getUniqueInstruments(userPortfolios);

        // Panen iga vastuse külge tema totalTransactionFee
        for (Instrument instrument : instruments) {
            List<Portfolio> portfoliosOfOneInstrument = portfolioRepository.findBy(userId, instrument.getId());
            float sum = 0.0F;
            BigDecimal totalSum = new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP);

            for (Portfolio portfolio : portfoliosOfOneInstrument) { // Käin läbi kõik selle instrumendiga portfellid
                if (portfolio.getTransactionFee() != null) {
                    float transactionFee = portfolio.getTransactionFee().floatValue();
                    sum += transactionFee; // Lisan selle instrumendi tehingutasu summasse
                }
            }
            // Lisan instrumendi keskmise hinna response body õige elemendi sisse
            for (PortfolioResponse response : responseList) {
                for (Portfolio userPortfolio : userPortfolios) {
                    if (userPortfolio.getInstrument().getTicker().equals(response.getTicker())) { // Vaatan, kas portfelli ticker on sama mis vastuse ticker
                        response.setTotalTransactionFee(totalSum.floatValue()); // Kui on sama, siis lisame keskmise hinna vastusesse
                    }
                }
            }
        }

        for (Instrument instrument : instruments) {
            List<Portfolio> portfoliosOfOneInstrument = portfolioRepository.findBy(userId, instrument.getId());
            float sumOfTransactionPrices = 0F;
            int numberOfInstruments = 0;

            for (Portfolio portfolio : portfoliosOfOneInstrument) { // Käin läbi kõik selle instrumendiga portfellid
                float transactionPrice = portfolio.getTransactionPrice().floatValue();
                sumOfTransactionPrices += transactionPrice; // Lisan selle instrumendi tehingutasu summasse
                Integer amount = portfolio.getAmount();
                numberOfInstruments += amount; // Salvestan selle instrumendi koguse muutujasse
            }
            float averageTransactionPrice = sumOfTransactionPrices / numberOfInstruments; //Leian keskmise tehingutasu
            BigDecimal avgTransactionPrice = new BigDecimal(averageTransactionPrice).setScale(2, RoundingMode.HALF_UP);

            // Lisan instrumendi koguse ja keskmise hinna response bodysse
            for (PortfolioResponse response : responseList) {
                if (response.getTicker().equals(instrument.getTicker())) {
                    response.setAvgBuyingPrice(avgTransactionPrice.floatValue()); // Kui on sama, siis lisame keskmise hinna vastusesse
                    response.setTotalAmount(numberOfInstruments);
                }
            }
        }

        for (Instrument instrument : instruments) {
            InstrumentResponse instrument1 = instrumentService.getInstrumentByTicker(instrument.getTicker());
            float currentPrice = instrument1.getCurrentPrice().floatValue();
            for (PortfolioResponse response : responseList) {
                float priceChangePercentage = response.getAvgBuyingPrice() / instrument1.getCurrentPrice().floatValue() * 100;
                BigDecimal changePercentage = valueOf(priceChangePercentage).setScale(2, RoundingMode.HALF_UP);

                float earning = instrument1.getCurrentPrice().floatValue() - response.getCurrentPrice();
                BigDecimal totalEarning = valueOf(earning).setScale(2, RoundingMode.HALF_UP);

                if (response.getTicker().equals(instrument.getTicker())) {
                    response.setCurrentPrice(currentPrice); // Kui on sama, siis lisame vastusesse
                    response.setPriceChangePercentage(changePercentage.floatValue());
                    response.setEarning(totalEarning.floatValue());
                }
            }
        }

        return responseList;
    }

    private static List<Instrument> getUniqueInstruments(List<Portfolio> userPortfolios) {
        List<Instrument> instruments = new ArrayList<>();
        for (Portfolio userPortfolio : userPortfolios) {
            Instrument instrument = userPortfolio.getInstrument();
            if (!instruments.contains(instrument)) {
                instruments.add(instrument);
            }
        }
        return instruments;
    }

    private List<PortfolioResponse> getResponses(List<Portfolio> userPortfolios) {
        List<PortfolioResponse> responseList = new ArrayList<>();
        for (Portfolio portfolio : userPortfolios) {
            PortfolioResponse response = portfolioMapper.portfolioToPortfolioResponse(portfolio); // Teen portfelli põhjal vastuse
            if (!responseList.contains(response)) { // Kui seda instrumenti vastuses ei ole, siis lisan
                responseList.add(response);
            }
        }
        return responseList;
    }
}
