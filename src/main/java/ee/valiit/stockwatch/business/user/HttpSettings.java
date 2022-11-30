package ee.valiit.stockwatch.business.user;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;

public class HttpSettings {

    public static final String API_KEY = "X-RapidAPI-Key";
    public static final String API_HOST = "X-RapidAPI-Host";
    public static final String API_KEY_VALUE = "7a67d740b4msh283926433a855f7p19cfe5jsnd8f8a1d93c85";
    public static final String API_HOST_VALUE = "apidojo-yahoo-finance-v1.p.rapidapi.com";
    public static final String BASE_URL = "https://apidojo-yahoo-finance-v1.p.rapidapi.com";
    public static final String TICKER_PREFIX = "/auto-complete?q=";
    public static final String REGION = "&region=US";

    public static HttpHeaders createRapidApiHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.add(API_KEY, API_KEY_VALUE);
        headers.add(API_HOST, API_HOST_VALUE);
        return headers;
    }
}
