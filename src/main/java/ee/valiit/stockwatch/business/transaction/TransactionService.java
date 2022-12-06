package ee.valiit.stockwatch.business.transaction;


import ee.valiit.stockwatch.business.portfolio.PortfolioRequest;
import ee.valiit.stockwatch.domain.portfolio.PortfolioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TransactionService {


    @Resource
    public PortfolioService portfolioService;


    public void setTransactionHistory(PortfolioRequest portfolioRequest) {
        portfolioService.setTransactionHistory(portfolioRequest);
    }
}
