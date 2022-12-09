package ee.valiit.stockwatch.business.transaction;

import ee.valiit.stockwatch.domain.transaction.TransactionDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController
public class TransactionController {

    @Resource
    private TransactionManagementService transactionManagementService;

    @GetMapping(value = "/history", produces = "application/json")
    @Operation(summary = "Kuvab tehingute ajaloo")
    public List<TransactionDto> getTransactionHistory(@RequestParam Integer userId, @RequestParam Integer transactionTypeId,
                                                      @RequestParam(required = false) LocalDate dateStart, @RequestParam(required = false) LocalDate dateEnd) {
        if (dateStart == null && dateEnd == null) {
            return transactionManagementService.getTransactionHistory(userId, transactionTypeId);
        } else {
            return transactionManagementService.findByUserIdAndTypeIdAndDate(userId, transactionTypeId, dateStart, dateEnd);
        }
    }
}
