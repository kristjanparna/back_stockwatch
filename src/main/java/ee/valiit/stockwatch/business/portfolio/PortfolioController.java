package ee.valiit.stockwatch.business.portfolio;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PortfolioController {

    @Resource
    public PortfolioManagementService portfolioManagementService;



    @PostMapping("/portfolio")
    @Operation(summary = "Lisab instrumendi portfelli ja tehingute ajaloo tabelisse")
    public void addTickerToPortfolio(@RequestBody PortfolioRequest portfolioRequest) {
        portfolioManagementService.addToPortfolio(portfolioRequest);
    }
}
