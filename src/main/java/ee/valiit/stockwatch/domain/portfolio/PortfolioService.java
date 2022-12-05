package ee.valiit.stockwatch.domain.portfolio;


import ee.valiit.stockwatch.business.portfolio.PortfolioRequest;
import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentService;
import ee.valiit.stockwatch.domain.user.user.User;
import ee.valiit.stockwatch.domain.user.user.UserService;
import ee.valiit.stockwatch.validation.Validation;
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
    private PortfolioRepository portfolioRepository;


    public void addInstrumentToPortfolio(PortfolioRequest portfolioRequest) {
        Instrument instrument = new Instrument();
        List<Instrument> allInstruments = instrumentService.findAllInstruments();
        instrument = checkIfInstrumentExists(portfolioRequest, instrument, allInstruments);
        Portfolio portfolio = portfolioMapper.portfolioRequestToPortfolio(portfolioRequest);
        createNewPortfolioItem(portfolioRequest, instrument, allInstruments, portfolio);
        portfolioRepository.save(portfolio);
    }

    private void createNewPortfolioItem(PortfolioRequest portfolioRequest, Instrument instrument, List<Instrument> allInstruments, Portfolio portfolio) {
        User user = userService.findUserById(portfolioRequest.getUserId());
        portfolio.setUser(user);
        portfolio.setPurchaseDate(LocalDate.now());
        portfolio.setInstrument(instrument);
        validateInstrumentNotInPortfolio(portfolioRequest, allInstruments);
    }

    private void validateInstrumentNotInPortfolio(PortfolioRequest portfolioRequest, List<Instrument> allInstruments) {
        List<Portfolio> allPortfolioItems = portfolioRepository.findAll();
        for (Portfolio portfolioItem : allPortfolioItems) {
            if (portfolioItem.getUser().getId().equals(portfolioRequest.getUserId())
            && portfolioItem.getInstrument().getTicker().equals(portfolioRequest.getTicker())) {
                Validation.validateTickerNotInPortfolio(allInstruments, portfolioRequest.getTicker());
            }
        }
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
