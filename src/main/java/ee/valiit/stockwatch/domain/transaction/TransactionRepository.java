package ee.valiit.stockwatch.domain.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("select t from Transaction t where t.portfolio.user.id = ?1")
    List<Transaction> findHistoryByUserId(Integer id);


}