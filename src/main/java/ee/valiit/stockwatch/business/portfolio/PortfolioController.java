package ee.valiit.stockwatch.business.portfolio;

import ee.valiit.stockwatch.business.transaction.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PortfolioController {

    @Resource
    public PortfolioManagementService portfolioManagementService;

    @Resource
    public TransactionService transactionService;

    @PostMapping("/portfolio")
    @Operation(summary = "Lisab instrumenti portfelli")
    public void addTickerToPortfolio(@RequestBody PortfolioRequest portfolioRequest) {
        portfolioManagementService.addToPortfolio(portfolioRequest);
        transactionService.setTransactionHistory(portfolioRequest);

    }

//    @PostMapping("/portfolio")
//    @Operation(summary = "Vähendab portfellis oleva instrumendi kogust")
//    public void reduceTickerInPortfolio() {
//
//    }
}
