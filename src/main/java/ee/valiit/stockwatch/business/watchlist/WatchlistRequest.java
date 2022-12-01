package ee.valiit.stockwatch.business.watchlist;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A DTO for the {@link ee.valiit.stockwatch.domain.watchlist.Watchlist} entity
 */
@Data
public class WatchlistRequest implements Serializable {
    private Integer userId;
}