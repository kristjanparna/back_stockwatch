package ee.valiit.stockwatch.business.user.watchlist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TickerController {

    @Resource
    RestTemplate restTemplate;

    @RequestMapping(value = "/ticker", method = RequestMethod.GET, produces = "application/json")
    public TickerInfo getTickerInfo(String search) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.add("X-RapidAPI-Key", "7a67d740b4msh283926433a855f7p19cfe5jsnd8f8a1d93c85");
        headers.add("X-RapidAPI-Host", "apidojo-yahoo-finance-v1.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String content = restTemplate.exchange("https://apidojo-yahoo-finance-v1.p.rapidapi.com/auto-complete?q=" + search + "&region=US",
                HttpMethod.GET, entity, String.class).getBody();
        Gson gson = new Gson();
        TickerInfo quotes = gson.fromJson(content, TickerInfo.class);



        return quotes;
    }

}
