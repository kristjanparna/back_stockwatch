package ee.valiit.stockwatch.domain.watchlist;

import ee.valiit.stockwatch.business.watchlist.WatchlistRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WatchlistMapper {
    @Mapping(source = "userId", target = "user.id")
    Watchlist watchlistRequestToWatchlist(WatchlistRequest watchlistRequest);
}
