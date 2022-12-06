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
public class TransactionResponse implements Serializable {
    private final Integer portfolioId;
    private final Integer portfolioUserId;
    @Size(max = 50)
    @NotNull
    private final String portfolioUserUsername;
    private final Integer portfolioInstrumentId;
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