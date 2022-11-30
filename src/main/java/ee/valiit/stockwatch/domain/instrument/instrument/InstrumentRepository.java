package ee.valiit.stockwatch.domain.instrument.instrument;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {
}