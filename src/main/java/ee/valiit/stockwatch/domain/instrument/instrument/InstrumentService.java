package ee.valiit.stockwatch.domain.instrument.instrument;

import ee.valiit.stockwatch.business.instrument.instrument.InstrumentInfo;
import ee.valiit.stockwatch.business.user.HttpSettings;
import ee.valiit.stockwatch.validation.Validation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

import static ee.valiit.stockwatch.business.user.HttpSettings.BASE_URL_SEARCH;
import static ee.valiit.stockwatch.business.user.HttpSettings.TICKER_PREFIX_SEARCH;

@Service
public class InstrumentService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private InstrumentRepository instrumentRepository;


    public InstrumentResponse getInstrumentByTicker(String ticker) {
        HttpHeaders headers = HttpSettings.createRapidApiHeaders();
        InstrumentInfo instrument = restTemplate.exchange(
                BASE_URL_SEARCH + TICKER_PREFIX_SEARCH + ticker, HttpMethod.GET,
                new HttpEntity<>(headers),
                InstrumentInfo.class
        ).getBody();
        return instrumentToInstrumentResponse(instrument);
    }

    private static InstrumentResponse instrumentToInstrumentResponse(InstrumentInfo instrument) {
        InstrumentResponse instrumentResponse = new InstrumentResponse();
        instrumentResponse.setTicker(instrument.getPrice().getSymbol());
        instrumentResponse.setShortName(instrument.getPrice().getShortName());
        instrumentResponse.setExchange(instrument.getPrice().getExchangeName());
        instrumentResponse.setCurrency(instrument.getPrice().getCurrency());
        instrumentResponse.setCurrencySymbol(instrument.getPrice().getCurrencySymbol());
        instrumentResponse.setCurrentPrice(instrument.getPrice().getRegularMarketPrice().getRaw());
        instrumentResponse.setPriceChangePercentage(instrument.getPrice().getRegularMarketChangePercent().getRaw());
        return instrumentResponse;
    }

    public void addNewInstrument(String ticker, String shortName) {
        Instrument instrument = new Instrument();
        List<Instrument> allInstruments = findAllInstruments();
        Validation.validateTickerExists(allInstruments, ticker);
        instrument.setTicker(ticker);
        instrument.setShortname(shortName);
        instrumentRepository.save(instrument);
    }

    public List<Instrument> findAllInstruments() {
        return instrumentRepository.findAll();
    }

    public Instrument findInstrumentByTicker(String ticker) {
        for (Instrument instrument : instrumentRepository.findAll()) {
            if (instrument.getTicker().equals(ticker)) {
                return instrument;
            }
        }
        return null;
    }

}
