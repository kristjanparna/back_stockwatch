package ee.valiit.stockwatch.business.user;

import ee.valiit.stockwatch.business.user.register.RegisterRequest;
import ee.valiit.stockwatch.domain.user.role.Role;
import ee.valiit.stockwatch.domain.user.role.RoleService;
import ee.valiit.stockwatch.domain.user.user.User;
import ee.valiit.stockwatch.domain.user.user.UserMapper;
import ee.valiit.stockwatch.domain.user.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserManagementService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;


    public LoginResponse login (String username, String password) {
        User user = userService.getValidUser(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }

    public void addUser(RegisterRequest registerRequest) {
        Role role = roleService.getRoleByType("customer");
        User user = userMapper.registerRequestToUser(registerRequest);
        user.setRole(role);
        userService.addUser(user);
        System.out.println();

//        Contact contact = contactMapper.registerRequestToContact(registerRequest);
//        contact.setFirstName(registerRequest.getContactFirstName());
//        contact.setLastName(registerRequest.getContactLastName());
//        contact.setEmail(registerRequest.getContactEmail());
//        user.setContact(contact);


    }
}
