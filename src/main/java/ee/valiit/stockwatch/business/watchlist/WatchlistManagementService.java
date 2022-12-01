package ee.valiit.stockwatch.business.watchlist;

import ee.valiit.stockwatch.domain.watchlist.WatchlistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WatchlistManagementService {

    @Resource
    private WatchlistService watchlistService;

    public void addInstrumentToWatchlist(WatchlistRequest request) {
        watchlistService.addInstrumentToWatchlist(request);
    }
}
