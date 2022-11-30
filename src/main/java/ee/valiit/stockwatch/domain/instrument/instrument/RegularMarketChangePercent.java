package ee.valiit.stockwatch.domain.instrument.instrument;

import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Price} entity
 */
@Data
public class RegularMarketChangePercent {
    private double raw;
}
