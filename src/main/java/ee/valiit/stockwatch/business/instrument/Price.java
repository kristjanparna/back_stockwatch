package ee.valiit.stockwatch.business.instrument;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link ee.valiit.stockwatch.domain.instrument.Instrument} entity
 */
@Data
public class Price implements Serializable {
    private String quoteSourceName;
    private String currencySymbol;
    private String currency;
    private RegularMarketPrice regularMarketPrice;
}