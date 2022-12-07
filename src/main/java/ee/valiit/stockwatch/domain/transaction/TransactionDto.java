package ee.valiit.stockwatch.domain.transaction;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A DTO for the {@link Transaction} entity
 */
@Data
public class TransactionDto implements Serializable {
    private final Integer portfolioId;
    @Size(max = 255)
    @NotNull
    private final String portfolioInstrumentTicker;
    @NotNull
    private final Integer transactionTypeId;
    @NotNull
    private final Integer amount;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final LocalDate date;
}