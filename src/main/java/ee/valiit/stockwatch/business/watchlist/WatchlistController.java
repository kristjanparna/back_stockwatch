package ee.valiit.stockwatch.business.watchlist;

import ee.valiit.stockwatch.domain.watchlist.WatchlistResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WatchlistController {

    @Resource
    private WatchlistManagementService watchlistManagementService;

    @PostMapping(value = "/watchlist")
    @Operation(summary = "Lisab kasutaja valitud instrumendi watchlisti")
    public void addInstrumentToWatchlist(@RequestBody AddWatchlistRequest request) {
        watchlistManagementService.addInstrumentToWatchlist(request);
    }


    @GetMapping(value = "/watchlist")
    @Operation(summary = "Tagastab kogu kasutaja watchlisti info")
    public WatchlistResponse getWatchlistData(Integer userId) {
        return watchlistManagementService.getWatchlistData(userId);
    }
}
