package ee.valiit.stockwatch.login;

import ee.valiit.stockwatch.user.User;
import ee.valiit.stockwatch.user.UserDto;
import ee.valiit.stockwatch.user.UserMapper;
import ee.valiit.stockwatch.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    public UserDto login(String username, String password) {
        User user = userService.getValidUser(username, password);
        UserDto userDto = userMapper.userToUserDto(user);
        return userDto;
    }

}
