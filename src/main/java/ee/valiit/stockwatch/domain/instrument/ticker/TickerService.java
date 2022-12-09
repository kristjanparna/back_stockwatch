package ee.valiit.stockwatch.domain.instrument.ticker;

import ee.valiit.stockwatch.business.instrument.ticker.TickerInfo;
import ee.valiit.stockwatch.business.user.HttpSettings;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

import static ee.valiit.stockwatch.business.user.HttpSettings.BASE_URL;
import static ee.valiit.stockwatch.business.user.HttpSettings.TICKER_PREFIX;

@Service
public class TickerService {

    @Resource
    private RestTemplate restTemplate;

    public List<Quote> getTickerInfo(String search) {
        HttpHeaders headers = HttpSettings.createRapidApiHeaders();
        TickerInfo info = restTemplate.exchange(
                BASE_URL + TICKER_PREFIX + search, HttpMethod.GET,
                new HttpEntity<>(headers),
                TickerInfo.class
        ).getBody();
        return info.getQuotes();
    }
}
