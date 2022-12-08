package ee.valiit.stockwatch.domain.instrument.instrument;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {

    @Override
    List<Instrument> findAll();
}