package ee.valiit.stockwatch.domain.watchlist;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A DTO for the {@link Watchlist} entity
 */

@Data
public class WatchlistResponse implements Serializable {
    private Integer id;
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
