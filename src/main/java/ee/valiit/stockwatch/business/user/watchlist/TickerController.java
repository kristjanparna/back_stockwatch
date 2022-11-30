package ee.valiit.stockwatch.business.user.watchlist;

import ee.valiit.stockwatch.business.user.HttpSettings;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

import static ee.valiit.stockwatch.business.user.HttpSettings.*;

@RestController
public class TickerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/ticker", produces = "application/json")
    @Operation(summary = "Tagastab nimekirja otsingu tulemustega")
    public List<Quote> getTickerInfo(String search)  {
        HttpHeaders headers = HttpSettings.createRapidApiHeaders();
        TickerInfo info = restTemplate.exchange(
                BASE_URL + TICKER_PREFIX + search + REGION, HttpMethod.GET,
                new HttpEntity<>(headers),
                TickerInfo.class
        ).getBody();
        return info.getQuotes();
     }

}
