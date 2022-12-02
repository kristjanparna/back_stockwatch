package ee.valiit.stockwatch.business.watchlist;

import ee.valiit.stockwatch.domain.watchlist.Watchlist;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link Watchlist} entity
 */
@Data
public class WatchlistRequest implements Serializable {
    private String ticker;
    private Integer userId;
    private BigDecimal priceHigher;
    private BigDecimal priceLower;
    @Size(max = 255)
    private String userComment;
    @NotNull
    private BigDecimal priceAtAddition;
}