package ee.valiit.stockwatch.business.user.watchlist;

import lombok.Data;

import java.util.List;

@Data
public class TickerInfoDto {
    private List<Quote> quotes;
}
