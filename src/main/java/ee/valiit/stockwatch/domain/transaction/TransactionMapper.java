package ee.valiit.stockwatch.domain.transaction;

import ee.valiit.stockwatch.business.portfolio.PortfolioRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "purchasePrice", target = "price")
    @Mapping(source = "purchaseDate", target = "date")
    @Mapping(source = "transactionTypeId", target = "transactionTypeId")
    Transaction portfolioRequestToTransaction(PortfolioRequest portfolioRequest);

    @Mapping(source = "portfolio.id", target = "portfolioId")
    TransactionDto transactionDtoToTransaction(Transaction transaction);

}
