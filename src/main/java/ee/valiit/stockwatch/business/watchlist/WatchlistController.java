package ee.valiit.stockwatch.business.watchlist;

import ee.valiit.stockwatch.domain.watchlist.WatchlistResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class WatchlistController {

    @Resource
    private WatchlistManagementService watchlistManagementService;


    @PostMapping(value = "/watchlist")
    @Operation(summary = "Lisab kasutaja valitud instrumendi watchlisti")
    public void addInstrumentToWatchlist(@RequestBody WatchlistRequest request) {
        watchlistManagementService.addInstrumentToWatchlist(request);
    }

    @GetMapping(value = "/watchlist")
    @Operation(summary = "Tagastab kogu kasutaja watchlisti info")
    public List<WatchlistResponse> getWatchlistData(Integer userId) {
        return watchlistManagementService.getWatchlistData(userId);
    }

    @DeleteMapping("/watchlist")
    @Operation(summary = "Eemaldab instrumendi jälgimisnimekirjast")
    public void removeFromWatchlist(Integer id) {
        watchlistManagementService.removeFromWatchlist(id);
    }

    @PutMapping("/watchlist")
    public void updateWatchlist(@RequestBody WatchlistRequest request) {
        request.getId();
    }
}
