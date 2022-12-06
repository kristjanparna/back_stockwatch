package ee.valiit.stockwatch.domain.transaction;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A DTO for the {@link Transaction} entity
 */
@Data
public class TransactionDto implements Serializable {
    private final Integer id;
    private final Integer portfolioId;
    @NotNull
    private final Integer amount;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final LocalDate date;
}