package ee.valiit.stockwatch.domain.instrument.instrument;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Price} entity
 */
@Data
public class RegularMarketPrice implements Serializable {
    private Double raw;
}
