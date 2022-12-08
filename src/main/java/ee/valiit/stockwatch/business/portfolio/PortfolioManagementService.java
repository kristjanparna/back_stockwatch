package ee.valiit.stockwatch.business.portfolio;


import ee.valiit.stockwatch.domain.portfolio.PortfolioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PortfolioManagementService {

    @Resource
    private PortfolioService portfolioService;

    public void addToPortfolio(PortfolioRequest portfolioRequest) {
        portfolioService.addInstrumentToPortfolio(portfolioRequest);
    }

    public void reduceInPortfolio(PortfolioRequest portfolioRequest) {
        portfolioService.reduceInPortfolio(portfolioRequest);
    }

    public List<PortfolioResponse> getPortfolioInformation(Integer userId) {
        return portfolioService.getPortfolioInformation(userId);
    }
}
