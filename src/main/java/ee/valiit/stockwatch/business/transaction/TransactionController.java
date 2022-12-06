package ee.valiit.stockwatch.business.transaction;

import ee.valiit.stockwatch.domain.transaction.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TransactionController {

    @Resource
    private TransactionManagementService transactionManagementService;

    @GetMapping("/history")
    @Operation(summary = "Kuvab tehingute ajaloo")
    public List<Transaction> getTransactionHistory(@RequestParam Integer userId) {
        List<Transaction> transactionHistory = transactionManagementService.getTransactionHistory(userId);
        return transactionHistory;
    }
}