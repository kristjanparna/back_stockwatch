package ee.valiit.stockwatch.business.instrument;

import ee.valiit.stockwatch.business.user.HttpSettings;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import static ee.valiit.stockwatch.business.user.HttpSettings.*;

@Service
public class InstrumentService {

    @Resource
    private RestTemplate restTemplate;

    public InstrumentInfo getInstrumentByTicker(String ticker) {
        HttpHeaders headers = HttpSettings.createRapidApiHeaders();
        InstrumentInfo instrument = restTemplate.exchange(
                BASE_URL_SEARCH + TICKER_PREFIX_SEARCH + ticker + REGION, HttpMethod.GET,
                new HttpEntity<>(headers),
                InstrumentInfo.class
        ).getBody();
        return instrument;
    }
}
