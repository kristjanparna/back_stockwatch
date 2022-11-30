package ee.valiit.stockwatch.domain.instrument.ticker;

import lombok.Data;

@Data
public class Quote {
    private String shortname;
    private String symbol;
    private String exchDisp;
}
