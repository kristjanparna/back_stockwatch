package ee.valiit.stockwatch.domain.watchlist;

import ee.valiit.stockwatch.business.watchlist.AddWatchlistRequest;
import ee.valiit.stockwatch.business.watchlist.WatchlistRequest;
import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentService;
import ee.valiit.stockwatch.domain.user.user.User;
import ee.valiit.stockwatch.domain.user.user.UserService;
import ee.valiit.stockwatch.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class WatchlistService {

    @Resource
    private WatchlistMapper watchlistMapper;

    @Resource
    private WatchlistRepository watchlistRepository;

    @Resource
    private InstrumentService instrumentService;

    @Resource
    private UserService userService;


    public WatchlistResponse getWatchlistData(Integer userId) {
        Watchlist watchlist = watchlistRepository.findByUserId(userId);
        WatchlistResponse response = new WatchlistResponse();
        response.setWatchlist(watchlist);

        Watchlist usersWatchlist = watchlistRepository.findByUserId(userId);


        return null;
    }

    public void addInstrumentToWatchlist(AddWatchlistRequest request) {
        Instrument instrument = new Instrument();
        List<Instrument> allInstruments = instrumentService.findAllInstruments();
        instrument = checkIfInstrumentExists(request, instrument, allInstruments);
        Watchlist watchlist = watchlistMapper.addWatchlistRequestToWatchlist(request);
        createNewWatchlistItem(request, instrument, allInstruments, watchlist);

        watchlistRepository.save(watchlist);
    }

    private void createNewWatchlistItem(AddWatchlistRequest request, Instrument instrument, List<Instrument> allInstruments, Watchlist watchlist) {
        User user = userService.findUserById(request.getUserId());
        watchlist.setUser(user);
        watchlist.setAdditionDate(LocalDate.now());
        watchlist.setInstrument(instrument);
        validateInstrumentNotInWatchlist(request, allInstruments);
    }

    private void validateInstrumentNotInWatchlist(AddWatchlistRequest request, List<Instrument> allInstruments) {
        List<Watchlist> allWatchlistItems = watchlistRepository.findAll();
        for (Watchlist watchlistItem : allWatchlistItems) {
            if (watchlistItem.getUser().getId().equals(request.getUserId())
                    && watchlistItem.getInstrument().getTicker().equals(request.getTicker())) {
                Validation.validateTickerNotInWatchlist(allInstruments, request.getTicker());
            }
        }
    }

    private Instrument checkIfInstrumentExists(AddWatchlistRequest request, Instrument instrument, List<Instrument> allInstruments) {
        for (Instrument existingInstrument : allInstruments) {
            if (existingInstrument.getTicker().equals(request.getTicker())) {
                instrument = existingInstrument;
            }
        }
        if (instrument.getTicker() == null) {
            instrument = addInstrument(request);
        }
        return instrument;
    }

    private Instrument addInstrument(AddWatchlistRequest request) {
        Instrument instrument;
        instrumentService.addNewInstrument(request.getTicker());
        instrument = instrumentService.findInstrumentByTicker(request.getTicker());
        return instrument;
    }


}
