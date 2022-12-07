package ee.valiit.stockwatch.domain.transaction;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransactionService {

    @Resource
    private TransactionRepository transactionRepository;

    @Resource
    private TransactionMapper transactionMapper;

    }

