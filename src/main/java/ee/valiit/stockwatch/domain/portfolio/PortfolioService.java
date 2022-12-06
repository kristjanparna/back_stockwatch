package ee.valiit.stockwatch.domain.portfolio;


import ee.valiit.stockwatch.business.portfolio.PortfolioRequest;
import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentService;
import ee.valiit.stockwatch.domain.transaction.Transaction;
import ee.valiit.stockwatch.domain.transaction.TransactionMapper;
import ee.valiit.stockwatch.domain.transaction.TransactionRepository;
import ee.valiit.stockwatch.domain.user.user.User;
import ee.valiit.stockwatch.domain.user.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
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
        Instrument instrument = new Instrument();
        List<Instrument> allInstruments = instrumentService.findAllInstruments();
        instrument = checkIfInstrumentExists(portfolioRequest, instrument, allInstruments);
        Portfolio portfolio = portfolioMapper.portfolioRequestToPortfolio(portfolioRequest);
        createNewPortfolioItem(portfolioRequest, instrument, portfolio);
        portfolioRepository.save(portfolio);
        addTransactionHistory(portfolioRequest, portfolio);
    }

    private void addTransactionHistory(PortfolioRequest portfolioRequest, Portfolio portfolio) {
        Transaction transaction = transactionMapper.portfolioRequestToTransaction(portfolioRequest);
        transactionMapper.transactionDtoToTransaction(transaction);
        createNewTransaction(portfolioRequest, transaction, portfolio);
        transactionRepository.save(transaction);
    }

    private void createNewTransaction(PortfolioRequest portfolioRequest, Transaction transaction, Portfolio portfolio) {
        transaction.setPortfolio(portfolio);
        transaction.setPrice(portfolioRequest.getPurchasePrice());
        transaction.setAmount(portfolioRequest.getAmount());
        transaction.setDate(LocalDate.now());
    }

    private void createNewPortfolioItem(PortfolioRequest portfolioRequest, Instrument instrument, Portfolio portfolio) {
        User user = userService.findUserById(portfolioRequest.getUserId());
        portfolio.setUser(user);
        portfolio.setPurchaseDate(LocalDate.now());
        portfolio.setInstrument(instrument);
    }

    private Instrument checkIfInstrumentExists(PortfolioRequest portfolioRequest, Instrument instrument, List<Instrument> allInstruments) {
        for (Instrument existingInstrument : allInstruments) {
            if (existingInstrument.getTicker().equals(portfolioRequest.getTicker())) {
                instrument = existingInstrument;
            }
        }
        if (instrument.getTicker() == null) {
            instrument = addInstrument(portfolioRequest);
        }
        return instrument;
    }

    private Instrument addInstrument(PortfolioRequest portfolioRequest) {
        Instrument instrument;
        instrumentService.addNewInstrument(portfolioRequest.getTicker());
        instrument = instrumentService.findInstrumentByTicker(portfolioRequest.getTicker());
        return instrument;
    }
}
