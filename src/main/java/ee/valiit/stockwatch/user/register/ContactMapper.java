package ee.valiit.stockwatch.user.register;


import ee.valiit.stockwatch.user.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {


    @Mapping(source = "contactFirstName", target = "firstName")
    @Mapping(source = "contactLastName", target = "lastName")
    @Mapping(source = "contactEmail", target = "email")
    Contact registerRequestToContact(RegisterRequest registerRequest);


}
