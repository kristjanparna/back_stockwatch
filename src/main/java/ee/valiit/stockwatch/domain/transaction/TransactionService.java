package ee.valiit.stockwatch.domain.transaction;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Resource
    private TransactionRepository transactionRepository;

    @Resource
    private TransactionMapper transactionMapper;


    public List<TransactionDto> getTransactionHistory (Integer userId) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        List<Transaction> transactions = transactionRepository.findHistoryByUserId(userId);
        for (Transaction transaction : transactions) {
            transactionDtos.add(transactionMapper.transactionToTransactionDto(transaction));
        }
        return transactionDtos;
    }
    }

