package ee.valiit.stockwatch.business.instrument;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link ee.valiit.stockwatch.domain.instrument.Instrument} entity
 */
@Data
public class RegularMarketPrice implements Serializable {
    private Double raw;
}
