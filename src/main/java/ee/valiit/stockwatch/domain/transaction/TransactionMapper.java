package ee.valiit.stockwatch.domain.transaction;

import ee.valiit.stockwatch.business.portfolio.PortfolioRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "purchasePrice", target = "price")
    @Mapping(source = "purchaseDate", target = "date")
    @Mapping(source = "transactionTypeId", target = "transactionTypeId")
    Transaction portfolioRequestToTransaction(PortfolioRequest portfolioRequest);

    @Mapping(source = "portfolioId", target = "portfolio.id")
    Transaction transactionDtoToTransaction(TransactionDto transactionDto);

    @Mapping(source = "portfolio.id", target = "portfolioId")
    TransactionDto transactionToTransactionDto(Transaction transaction);

    @Mapping(source = "portfolioId", target = "portfolio.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Transaction updateTransactionFromTransactionDto(TransactionDto transactionDto, @MappingTarget Transaction transaction);
}
