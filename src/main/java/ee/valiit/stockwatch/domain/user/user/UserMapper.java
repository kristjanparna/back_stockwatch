package ee.valiit.stockwatch.domain.user.user;

import ee.valiit.stockwatch.business.user.login.LoginResponse;
import ee.valiit.stockwatch.business.user.register.RegisterRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    User registerRequestToUser(RegisterRequest registerRequest);

    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "username", target = "username")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "contact.firstName", target = "firstname")
    @Mapping(source = "contact.lastName", target = "lastname")
    @Mapping(source = "contact.email", target = "email")
    @Mapping(source = "contact.start", target = "startDate")
    UserResponse userToUserResponse(User user);

}
