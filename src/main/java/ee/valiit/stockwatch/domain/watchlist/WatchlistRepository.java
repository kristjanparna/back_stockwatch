package ee.valiit.stockwatch.domain.watchlist;

import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface WatchlistRepository extends org.springframework.data.jpa.repository.JpaRepository<Watchlist, Integer> {
    @Query("select w from Watchlist w where w.user.id = ?1")
    Watchlist findByUserId(Integer id);



    @Query("select w from Watchlist w where w.user.id = ?1")
    List<Watchlist> findAllByUserId(Integer id);

    @Transactional
    @Modifying
    @Query("delete from Watchlist w where w.instrument = ?1")
    int deleteByInstrument(Instrument instrument);

    @Override
    void deleteById(Integer integer);

    @Transactional
    @Modifying
    @Query("""
            update Watchlist w set w.priceHigher = ?1, w.priceLower = ?2, w.userComment = ?3, w.priceAtAddition = ?4, w.additionDate = ?5
            where w.id = ?6""")
    int updateId(BigDecimal priceHigher, BigDecimal priceLower, String userComment, BigDecimal priceAtAddition, LocalDate additionDate, Integer id);

}