package ee.valiit.stockwatch.business.instrument;

import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentResponse;
import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentService;
import ee.valiit.stockwatch.domain.instrument.ticker.Quote;
import ee.valiit.stockwatch.domain.instrument.ticker.TickerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class InstrumentController {

    @Resource
    private InstrumentService instrumentService;

    @Resource
    private TickerService tickerService;

    @GetMapping(value = "/ticker", produces = "application/json")
    @Operation(summary = "Tagastab nimekirja tickeri otsingu tulemustega")
    public List<Quote> getTickerInfo(String search)  {
        List<Quote> info = tickerService.getTickerInfo(search);
        return info;
    }


    @GetMapping(value = "/search", produces = "application/json")
    @Operation(summary = "Tagastab konkreetse instrumendi info välisest API'st")
    public InstrumentResponse getInstrument(String ticker) {
        InstrumentResponse instrumentResponse = instrumentService.getInstrumentByTicker(ticker);
        return instrumentResponse;
    }
}
