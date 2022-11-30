package ee.valiit.stockwatch.domain.instrument.instrument;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Instrument} entity
 */
@Data
public class Price implements Serializable {
    private String shortName;
    private String currencySymbol;
    private String exchangeName;
    private String currency;
    private String symbol;
    private RegularMarketPrice regularMarketPrice;
    private RegularMarketChangePercent regularMarketChangePercent;
}