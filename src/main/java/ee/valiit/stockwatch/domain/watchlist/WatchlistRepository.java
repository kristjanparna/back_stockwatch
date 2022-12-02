package ee.valiit.stockwatch.domain.watchlist;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WatchlistRepository extends org.springframework.data.jpa.repository.JpaRepository<Watchlist, Integer> {
    @Query("select w from Watchlist w where w.user.id = ?1")
    Watchlist findByUserId(Integer id);

    @Query("select w from Watchlist w where w.user.id = ?1")
    List<Watchlist> findAllByUserId(Integer id);


}