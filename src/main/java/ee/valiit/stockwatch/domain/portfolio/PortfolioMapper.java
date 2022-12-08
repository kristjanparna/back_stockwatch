package ee.valiit.stockwatch.domain.portfolio;


import ee.valiit.stockwatch.business.portfolio.PortfolioRequest;
import ee.valiit.stockwatch.business.portfolio.PortfolioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PortfolioMapper {

    @Mapping(source = "userId", target = "user.id")
    Portfolio portfolioRequestToPortfolio(PortfolioRequest portfolioRequest);

    @Mapping(source = "instrument.ticker", target = "ticker")
    @Mapping(source = "instrument.shortname", target = "shortName")
    PortfolioResponse portfolioToPortfolioResponse(Portfolio portfolio);
}
