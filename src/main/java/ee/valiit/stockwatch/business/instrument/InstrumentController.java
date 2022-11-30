package ee.valiit.stockwatch.business.instrument;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class InstrumentController {

    @Resource
    private InstrumentService instrumentService;

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/search", produces = "application/json")
    @Operation(summary = "Tagastab nimekirja valitud instrumendi infoga")
    public InstrumentInfo getInstrument(String ticker) {
        InstrumentInfo instrument = instrumentService.getInstrumentByTicker(ticker);
        return instrument;
    }
}
