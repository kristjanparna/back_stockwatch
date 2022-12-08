package ee.valiit.stockwatch.business.portfolio;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PortfolioController {

    @Resource
    public PortfolioManagementService portfolioManagementService;

    @PostMapping("/portfolio")
    @Operation(summary = "Lisab instrumendi portfelli ja tehingute ajaloo tabelisse")
    public void addTickerToPortfolio(@RequestBody PortfolioRequest portfolioRequest) {
        portfolioManagementService.addToPortfolio(portfolioRequest);
    }

    @PutMapping("/portfolio")
    @Operation(summary = "Vähendab instrumendi kogust portfellis ja lisab tegevuse tehingute ajaloo tabelisse")
    public void reduceTickerAmount(@RequestBody PortfolioRequest portfolioRequest) {
        portfolioManagementService.reduceInPortfolio(portfolioRequest);
    }

    @GetMapping("/portfolio")
    @Operation(summary = "Tagastab listi kasutaja portfellis olevate instrumentede infoga")
    public List<PortfolioResponse> getPortfolioInformation(Integer userId) {
        return portfolioManagementService.getPortfolioInformation(userId);
    }

    @GetMapping("/portfolio/all")
    @Operation(summary = "Tagastab kogu kasutaja portfelli väärtuse")
    public float getTotalPortfolioValue(Integer userId) {
        return portfolioManagementService.getTotalPortfolioValue(userId);
    }
}
