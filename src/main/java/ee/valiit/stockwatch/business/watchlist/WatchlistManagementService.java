package ee.valiit.stockwatch.business.watchlist;

import ee.valiit.stockwatch.domain.watchlist.WatchlistResponse;
import ee.valiit.stockwatch.domain.watchlist.WatchlistService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
public class WatchlistManagementService {

    @Resource
    private WatchlistService watchlistService;

    public void addInstrumentToWatchlist(AddWatchlistRequest request) {
        watchlistService.addInstrumentToWatchlist(request);
    }

    public WatchlistResponse getWatchlistData(Integer userId) {
        return watchlistService.getWatchlistData(userId);
    }
}
