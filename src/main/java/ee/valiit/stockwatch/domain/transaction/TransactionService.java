package ee.valiit.stockwatch.domain.transaction;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Resource
    private TransactionRepository transactionRepository;

    @Resource
    private TransactionMapper transactionMapper;


    public List<TransactionDto> getTransactionHistory(Integer userId, Integer transactionTypeId) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        List<Transaction> transactionsById;
        if (transactionTypeId == 1 || transactionTypeId == 2) {
            transactionsById = transactionRepository.findByTypeAndUserId(transactionTypeId, userId);
            for (Transaction transaction : transactionsById) {
                transactionDtos.add(transactionMapper.transactionToTransactionDto(transaction));
            }
        } else {
            transactionsById = transactionRepository.findHistoryByUserId(userId);
            for (Transaction transaction : transactionsById) {
                transactionDtos.add(transactionMapper.transactionToTransactionDto(transaction));
            }
        }
        return transactionDtos;

    }

    public List<TransactionDto> getTransactionHistory(Integer userId, Integer transactionTypeId, LocalDate dateStart, LocalDate dateEnd) {
        List<TransactionDto> transactionDtosByDate = new ArrayList<>();
        if (transactionTypeId == 1 || transactionTypeId == 2) {
            List<Transaction> transactionsByIdAndDate = transactionRepository.findByUserIdAndTypeIdAndDate(userId, transactionTypeId, dateStart, dateEnd);
            for (Transaction transaction : transactionsByIdAndDate) {
                transactionDtosByDate.add(transactionMapper.transactionToTransactionDto(transaction));
            } return transactionDtosByDate;
        } else {
            List<Transaction> transactionsByIdAndDate = transactionRepository.findByUserIdAndDate(userId, dateStart,dateEnd);
            for (Transaction transaction : transactionsByIdAndDate) {
                transactionDtosByDate.add(transactionMapper.transactionToTransactionDto(transaction));
            }
        return transactionDtosByDate;
        }
    }
}
