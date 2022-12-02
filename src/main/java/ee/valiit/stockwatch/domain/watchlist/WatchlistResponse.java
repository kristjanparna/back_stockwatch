package ee.valiit.stockwatch.domain.watchlist;

import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentResponse;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * A DTO for the {@link Watchlist} entity
 */

@Data
public class WatchlistResponse implements Serializable {
    private String ticker;
    private String shortName;
    private String currency;
    private Double currentPrice;
    private Double priceChangePercentage;
    private BigDecimal priceHigher;
    private BigDecimal priceLower;
    private String userComment;
    private BigDecimal priceAtAddition;
    private LocalDate additionDate;
}
