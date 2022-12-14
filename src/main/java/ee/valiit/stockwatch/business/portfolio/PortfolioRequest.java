package ee.valiit.stockwatch.business.portfolio;

import ee.valiit.stockwatch.domain.portfolio.Portfolio;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A DTO for the {@link Portfolio} entity
 */
@Data
public class PortfolioRequest implements Serializable {
    private Integer userId;
    @Size(max = 255)
    @NotNull
    private String ticker;
    @NotNull
    private BigDecimal transactionPrice;
    @NotNull
    private Integer amount;
    private BigDecimal transactionFee;
    @NotNull
    private LocalDate transactionDate;
    @NotNull
    private Integer transactionTypeId;
    @Size(max = 255)
    @NotNull
    private String shortName;
}