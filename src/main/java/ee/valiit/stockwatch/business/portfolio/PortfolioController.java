package ee.valiit.stockwatch.business.portfolio;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {


    @PostMapping("portfolio")
    @Operation(summary = "Lisab instrumenti portfelli")
    public void addTickerToPortfolio(@RequestBody PortfolioRequest portfolioRequest) {

    }

}
