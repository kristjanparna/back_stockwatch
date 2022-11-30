package ee.valiit.stockwatch.business.instrument.instrument;

import ee.valiit.stockwatch.domain.instrument.instrument.Price;
import lombok.Data;

@Data
public class InstrumentInfo {
    private Price price;
}
