package ee.valiit.stockwatch.business.portfolio;

import ee.valiit.stockwatch.domain.portfolio.Portfolio;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link Portfolio} entity
 */
@Data
public class PortfolioResponse implements Serializable {
    @Size(max = 255)
    @NotNull
    private final String ticker;
    @NotNull
    private final Integer amount;
    private final BigDecimal transactionFee;
    @NotNull
    private final BigDecimal avgBuyingPrice;
    private final BigDecimal currentPrice;
    private final BigDecimal priceChangePercentage;
    private final BigDecimal earning;
}
