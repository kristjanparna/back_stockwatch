package ee.valiit.stockwatch.business.transaction;


import ee.valiit.stockwatch.domain.transaction.Transaction;
import ee.valiit.stockwatch.domain.transaction.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransactionManagementService {

    @Resource
    private TransactionService transactionService;

    public List<Transaction> getTransactionHistory(Integer userId) {
        List<Transaction> transactionHistory = transactionService.getTransactionHistory(userId);
        return transactionHistory;
    }

}
