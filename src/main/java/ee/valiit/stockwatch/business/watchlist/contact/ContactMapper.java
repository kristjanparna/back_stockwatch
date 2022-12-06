package ee.valiit.stockwatch.business.watchlist.contact;


import ee.valiit.stockwatch.business.user.register.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {

    @Mapping(source = "firstname", target = "firstName")
    @Mapping(source = "lastname", target = "lastName")
    Contact registerRequestToContact(RegisterRequest registerRequest);
}
