package ee.valiit.stockwatch.business.user;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;

public class HttpSettings {

    public static final String API_KEY = "X-RapidAPI-Key";
    public static final String API_HOST = "X-RapidAPI-Host";
    public static final String API_KEY_VALUE = "143f650547msh3b6b23a8bcfaadfp102078jsn30a376c71534";
    public static final String API_HOST_VALUE = "apidojo-yahoo-finance-v1.p.rapidapi.com";
    public static final String BASE_URL = "https://apidojo-yahoo-finance-v1.p.rapidapi.com";
    public static final String BASE_URL_SEARCH = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2";
    public static final String TICKER_PREFIX = "/auto-complete?q=";
    public static final String TICKER_PREFIX_SEARCH = "/get-profile?symbol=";
    public static final String REGION = "&region=US";

    public static HttpHeaders createRapidApiHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.add(API_KEY, API_KEY_VALUE);
        headers.add(API_HOST, API_HOST_VALUE);
        return headers;
    }
}
