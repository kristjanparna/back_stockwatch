package ee.valiit.stockwatch.domain.transaction;

import ee.valiit.stockwatch.business.portfolio.PortfolioRequest;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "transactionPrice", target = "price")
    @Mapping(source = "transactionDate", target = "date")
    @Mapping(source = "transactionTypeId", target = "transactionTypeId")
    Transaction portfolioRequestToTransaction(PortfolioRequest portfolioRequest);

    @Mapping(source = "portfolio.id", target = "portfolioId")
    TransactionDto transactionDtoToTransaction(Transaction transaction);

    @Mapping(source = "portfolio.instrument.shortname", target = "portfolioInstrumentTicker")
    @Mapping(source = "portfolio.transactionFee", target = "transactionFee")
    @InheritInverseConfiguration(name = "transactionDtoToTransaction1")
    TransactionDto transactionToTransactionDto(Transaction transaction);
}
