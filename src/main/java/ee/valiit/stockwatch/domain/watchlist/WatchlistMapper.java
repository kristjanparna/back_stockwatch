package ee.valiit.stockwatch.domain.watchlist;

import ee.valiit.stockwatch.business.watchlist.WatchlistRequest;
import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WatchlistMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "instrumentId", target = "instrument.id")
    Watchlist watchlistRequestToWatchlist(WatchlistRequest watchlistRequest);

}
