package ee.valiit.stockwatch.domain.portfolio;


import ee.valiit.stockwatch.business.portfolio.PortfolioRequest;
import ee.valiit.stockwatch.business.portfolio.PortfolioResponse;
import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
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
import java.util.ArrayList;
import java.util.List;

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


    public void getPortfolioInformation(Integer userId) {
        List<Portfolio> userPortfolios = portfolioRepository.findByUserId(userId); // Leiab kõik selle kasutaja portfellid

        List<PortfolioResponse> responseList = new ArrayList<>(); // List kõikidest vastustest, mis tuleb Fronti saata

        for (Portfolio portfolio : userPortfolios) {
            PortfolioResponse response = portfolioMapper.portfolioToPortfolioResponse(portfolio); // Teen portfelli põhjal vastuse
            if (!responseList.contains(response)) { // Kui seda instrumenti vastuses ei ole, siis lisan
                responseList.add(response);
            }
        }

        // Leian selle kasutaja portfellist kõik unikaalsed instrumendid

        List<Instrument> instruments = new ArrayList<>(); // List unikaalsetest instrumentidest, mis on selle kasutaja portfellis
        for (Portfolio userPortfolio : userPortfolios) {
            Instrument instrument = userPortfolio.getInstrument();
            if (!instruments.contains(instrument)) {
                instruments.add(instrument);
            }
        }

        // Käin läbi kõik instrumendid ja arvutan nende keskmise ostuhinna
        for (Instrument instrument : instruments) {
            List<Portfolio> portfoliosOfOneInstrument = portfolioRepository.findBy(userId, instrument.getId());
            BigDecimal sum = new BigDecimal(0.0); // Ühe instrumendi keskmine hind
            for (Portfolio portfolio : portfoliosOfOneInstrument) {
                BigDecimal transactionPrice = portfolio.getTransactionPrice();
                sum.add(transactionPrice);
            }

            // Lisan instrumendi keskmise hinna response body õige elemendi sisse
            for (PortfolioResponse response : responseList) {
                for (Portfolio userPortfolio : userPortfolios) {
                    if (userPortfolio.getInstrument().getTicker().equals(response.getTicker())) { // Vaatan, kas portfelli ticker on sama mis vastuse ticker
                        response.setAvgBuyingPrice(sum); // Kui on sama, siis lisame keskmise hinna vastusesse
                    }
                }
            }
        }

        System.out.println();

    }
}
