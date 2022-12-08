package ee.valiit.stockwatch.domain.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("select t from Transaction t where t.portfolio.user.id = ?1")
    List<Transaction> findHistoryByUserId(Integer id);

    @Query("select t from Transaction t where t.transactionTypeId = ?1 and t.portfolio.user.id = ?2")
    List<Transaction> findByTypeAndUserId(Integer transactionTypeId, Integer id);

    @Query("""
            select t from Transaction t
            where t.portfolio.user.id = ?1 and t.transactionTypeId = ?2 and t.date between ?3 and ?4""")
    List<Transaction> findByUserIdAndTypeIdAndDate(Integer id, Integer transactionTypeId, LocalDate dateStart, LocalDate dateEnd);

    @Query("select t from Transaction t where t.portfolio.user.id = ?1 and t.date between ?2 and ?3")
    List<Transaction> findByUserIdAndDate(Integer id, LocalDate dateStart, LocalDate dateEnd);

}