package ee.valiit.stockwatch.business.user.watchlist;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TickerMapper {
    TickerInfoDto toDto(TickerInfo info);

    List<TickerInfoDto> toDtos(List<TickerInfo> infos);
}
