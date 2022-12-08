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
    private String ticker;
    private Integer totalAmount;
    private float totalTransactionFee;
    private float avgBuyingPrice;
    private float currentPrice;
    private float priceChangePercentage;
    private float earning;

}

