package ee.valiit.stockwatch.domain.user.user;

import ee.valiit.stockwatch.business.user.LoginResponse;
import ee.valiit.stockwatch.business.user.register.RegisterRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    User registerRequestToUser(RegisterRequest registerRequest);

    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "id", target = "userId")
    LoginResponse toLoginResponse(User user);
}
