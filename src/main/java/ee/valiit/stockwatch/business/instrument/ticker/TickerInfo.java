package ee.valiit.stockwatch.business.instrument.ticker;

import ee.valiit.stockwatch.domain.instrument.ticker.Quote;
import lombok.Data;

import java.util.List;

@Data
public class TickerInfo {

    private List<Quote> quotes;

}
