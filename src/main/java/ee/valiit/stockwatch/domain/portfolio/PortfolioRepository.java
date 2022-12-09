package ee.valiit.stockwatch.domain.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
    @Query("select p from Portfolio p where p.user.id = ?1 and p.instrument.id = ?2")
    List<Portfolio> findBy(Integer userId, Integer instrumentId);

    List<Portfolio> findByUserId(Integer userId);
}