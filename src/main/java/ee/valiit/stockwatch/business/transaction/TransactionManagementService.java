package ee.valiit.stockwatch.business.transaction;


import ee.valiit.stockwatch.domain.transaction.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TransactionManagementService {

    @Resource
    private TransactionService transactionService;

    public void getTransactionHistory(Integer userId) {

    }

}
