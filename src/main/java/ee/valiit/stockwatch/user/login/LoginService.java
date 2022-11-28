package ee.valiit.stockwatch.user.login;

import ee.valiit.stockwatch.user.user.UserMapper;
import ee.valiit.stockwatch.user.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    public LoginResponse login (String username, String password) {
        User user = userService.getValidUser(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }
}
