package ee.valiit.stockwatch.business.watchlist;

import ee.valiit.stockwatch.domain.watchlist.WatchlistResponse;
import ee.valiit.stockwatch.domain.watchlist.WatchlistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WatchlistManagementService {

    @Resource
    private WatchlistService watchlistService;

    public void addInstrumentToWatchlist(WatchlistRequest request) {
        watchlistService.addInstrumentToWatchlist(request);
    }

    public List<WatchlistResponse> getWatchlistData(Integer userId) {
        return watchlistService.getWatchlistData(userId);
    }

    public void removeFromWatchlist(Integer id) {
        watchlistService.removeFromWatchlist(id);
    }
}
