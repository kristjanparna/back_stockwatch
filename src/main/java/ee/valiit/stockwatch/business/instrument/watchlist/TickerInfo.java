package ee.valiit.stockwatch.business.instrument.watchlist;

import ee.valiit.stockwatch.business.instrument.watchlist.Quote;
import lombok.Data;

import java.util.List;

@Data
public class TickerInfo {

    private List<Quote> quotes;

}
