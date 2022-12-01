package ee.valiit.stockwatch.business.instrument;

import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentResponse;
import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentService;
import ee.valiit.stockwatch.domain.instrument.ticker.Quote;
import ee.valiit.stockwatch.domain.instrument.ticker.TickerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InstrumentManagementService {

    @Resource
    private TickerService tickerService;

    @Resource
    private InstrumentService instrumentService;

    public List<Quote> getTickerInfo(String search) {
        List<Quote> info = tickerService.getTickerInfo(search);
        return info;
    }

    public InstrumentResponse getInstrument(String symbol) {
        InstrumentResponse instrumentResponse = instrumentService.getInstrumentByTicker(symbol);
        return instrumentResponse;
    }
}
