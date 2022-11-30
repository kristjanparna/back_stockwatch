package ee.valiit.stockwatch.domain.instrument.instrument;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Instrument} entity
 */
@Data
public class InstrumentResponse implements Serializable {
    private String ticker;
    private String exchange;
    private String shortName;
    private String currencySymbol;
    private String currency;
    private Double currentPrice;
    private Double priceChangePercentage;
}