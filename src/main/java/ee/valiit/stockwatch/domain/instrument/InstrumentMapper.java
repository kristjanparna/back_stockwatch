package ee.valiit.stockwatch.domain.instrument;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InstrumentMapper {
    Instrument instrumentDtoToInstrument(InstrumentRequest instrumentRequest);

    InstrumentRequest instrumentToInstrumentDto(Instrument instrument);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Instrument updateInstrumentFromInstrumentDto(InstrumentRequest instrumentRequest, @MappingTarget Instrument instrument);
}
