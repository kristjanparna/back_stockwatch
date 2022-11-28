package ee.valiit.stockwatch.user.user;

import ee.valiit.stockwatch.user.login.LoginResponse;
import ee.valiit.stockwatch.user.login.User;
import ee.valiit.stockwatch.user.user.UserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "id" , target = "userId")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "role.id", target = "roleId")
    UserDto userToUserDto(User user);

}
