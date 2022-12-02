package ee.valiit.stockwatch.domain.watchlist;

import ee.valiit.stockwatch.business.watchlist.WatchlistRequest;
import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentResponse;
import ee.valiit.stockwatch.domain.instrument.instrument.InstrumentService;
import ee.valiit.stockwatch.domain.user.user.User;
import ee.valiit.stockwatch.domain.user.user.UserService;
import ee.valiit.stockwatch.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
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


    public List<WatchlistResponse> getWatchlistData(Integer userId) {
        List<Watchlist> userWatchlists = watchlistRepository.findAllByUserId(userId);
        List<WatchlistResponse> responseList = combineWatchlistResponse(userWatchlists);
        return responseList;
    }

    private List<WatchlistResponse> combineWatchlistResponse(List<Watchlist> watchlists) {
        List<WatchlistResponse> responseList = new ArrayList<>();
        for (Watchlist watchlist : watchlists) {
            WatchlistResponse response = watchlistToWatchlistResponse(watchlist);
            instrumentToWatchlistResponse(watchlist, response);
            responseList.add(response);
        }
        return responseList;
    }

    private void instrumentToWatchlistResponse(Watchlist watchlist, WatchlistResponse response) {
        InstrumentResponse instrument = instrumentService.getInstrumentByTicker(watchlist.getInstrument().getTicker());
        response.setCurrency(instrument.getCurrency());
        response.setCurrentPrice(instrument.getCurrentPrice());
        response.setTicker(instrument.getTicker());
        response.setPriceChangePercentage(instrument.getPriceChangePercentage());
        response.setShortName(instrument.getShortName());
    }

    private static WatchlistResponse watchlistToWatchlistResponse(Watchlist watchlist) {
        WatchlistResponse response = new WatchlistResponse();
        response.setAdditionDate(watchlist.getAdditionDate());
        response.setPriceHigher(watchlist.getPriceHigher());
        response.setPriceLower(watchlist.getPriceLower());
        response.setPriceAtAddition(watchlist.getPriceAtAddition());
        response.setUserComment(watchlist.getUserComment());
        return response;
    }

    public void addInstrumentToWatchlist(WatchlistRequest request) {
        Instrument instrument = new Instrument();
        List<Instrument> allInstruments = instrumentService.findAllInstruments();
        instrument = checkIfInstrumentExists(request, instrument, allInstruments);
        Watchlist watchlist = watchlistMapper.watchlistRequestToWatchlist(request);
        createNewWatchlistItem(request, instrument, allInstruments, watchlist);

        watchlistRepository.save(watchlist);
    }

    private void createNewWatchlistItem(WatchlistRequest request, Instrument instrument, List<Instrument> allInstruments, Watchlist watchlist) {
        User user = userService.findUserById(request.getUserId());
        watchlist.setUser(user);
        watchlist.setAdditionDate(LocalDate.now());
        watchlist.setInstrument(instrument);
        validateInstrumentNotInWatchlist(request, allInstruments);
    }

    private void validateInstrumentNotInWatchlist(WatchlistRequest request, List<Instrument> allInstruments) {
        List<Watchlist> allWatchlistItems = watchlistRepository.findAll();
        for (Watchlist watchlistItem : allWatchlistItems) {
            if (watchlistItem.getUser().getId().equals(request.getUserId())
                    && watchlistItem.getInstrument().getTicker().equals(request.getTicker())) {
                Validation.validateTickerNotInWatchlist(allInstruments, request.getTicker());
            }
        }
    }

    private Instrument checkIfInstrumentExists(WatchlistRequest request, Instrument instrument, List<Instrument> allInstruments) {
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

    private Instrument addInstrument(WatchlistRequest request) {
        Instrument instrument;
        instrumentService.addNewInstrument(request.getTicker());
        instrument = instrumentService.findInstrumentByTicker(request.getTicker());
        return instrument;
    }


}
