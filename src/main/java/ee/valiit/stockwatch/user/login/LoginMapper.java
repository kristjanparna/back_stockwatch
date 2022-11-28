package ee.valiit.stockwatch.user.login;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LoginMapper {


    @Mapping(source = "role.id", target = "roleId")
    LoginResponse userToLoginDto(User user);

}
