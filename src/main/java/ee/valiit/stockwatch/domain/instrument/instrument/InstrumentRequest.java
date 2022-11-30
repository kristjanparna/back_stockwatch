package ee.valiit.stockwatch.domain.instrument.instrument;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Instrument} entity
 */
@Data
public class InstrumentRequest implements Serializable {
    private String ticker;
}