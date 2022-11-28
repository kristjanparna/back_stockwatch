package ee.valiit.stockwatch.user.register;

import ee.valiit.stockwatch.user.login.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RegisterMapper {

//    @Mapping(source = "contactFirstName", target = "contact.firstName")
//    @Mapping(source = "contactLastName", target = "contact.lastName")
//    @Mapping(source = "contactEmail", target = "contact.email")
    User registerRequestToUser(RegisterRequest registerRequest);

}
