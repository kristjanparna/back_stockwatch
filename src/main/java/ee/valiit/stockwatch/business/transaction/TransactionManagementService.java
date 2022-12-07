package ee.valiit.stockwatch.business.transaction;


import ee.valiit.stockwatch.domain.transaction.TransactionDto;
import ee.valiit.stockwatch.domain.transaction.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransactionManagementService {

    @Resource
    private TransactionService transactionService;

    public List<TransactionDto> getTransactionHistory(Integer userId) {
        return transactionService.getTransactionHistory(userId);
    }


}
