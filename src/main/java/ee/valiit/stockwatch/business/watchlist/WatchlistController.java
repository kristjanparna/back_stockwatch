package ee.valiit.stockwatch.business.watchlist;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WatchlistController {

    @Resource
    private WatchlistManagementService watchlistManagementService;

    @PostMapping(value = "/watchlist/add")
    @Operation(summary = "Lisab kasutaja valitud instrumendi watchlisti")
    public void addInstrumentToWatchlist(WatchlistRequest request) {
        watchlistManagementService.addInstrumentToWatchlist(request);
    }
}
