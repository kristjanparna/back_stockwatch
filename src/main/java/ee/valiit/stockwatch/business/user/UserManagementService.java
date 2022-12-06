package ee.valiit.stockwatch.business.user;

import ee.valiit.stockwatch.business.user.login.LoginResponse;
import ee.valiit.stockwatch.business.user.register.RegisterRequest;
import ee.valiit.stockwatch.business.watchlist.contact.Contact;
import ee.valiit.stockwatch.business.watchlist.contact.ContactMapper;
import ee.valiit.stockwatch.business.watchlist.contact.ContactService;
import ee.valiit.stockwatch.domain.user.role.Role;
import ee.valiit.stockwatch.domain.user.role.RoleService;
import ee.valiit.stockwatch.domain.user.user.User;
import ee.valiit.stockwatch.domain.user.user.UserMapper;
import ee.valiit.stockwatch.domain.user.user.UserResponse;
import ee.valiit.stockwatch.domain.user.user.UserService;
import ee.valiit.stockwatch.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagementService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private ContactService contactService;

    public LoginResponse login(String username, String password) {
        User user = userService.getValidUser(username, password);
        Validation.validateUserIsActive(user);
        return userMapper.toLoginResponse(user);
    }

    public void addUser(RegisterRequest registerRequest) {
        Role role = roleService.getRoleByType("customer");

        Contact contact = contactMapper.registerRequestToContact(registerRequest);
        contact.setStart(LocalDate.now());
        contactService.addContact(contact);

        User user = userMapper.registerRequestToUser(registerRequest);
        user.setRole(role);
        user.setContact(contact);
        userService.addUser(user);
    }

    public List<UserResponse> getUsersInfo() {
        List<User> allUsers = userService.getUsersInfo();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : allUsers) {
            if (user.getContact() != null && user.getContact().getEnd() == null) {
                UserResponse userResponse = userMapper.userToUserResponse(user);
                userResponses.add(userResponse);
            }
        }
        return userResponses;
    }

    public void deactivateUser(String username) {
        userService.deactivateUser(username);
    }

    public void editUser(String username, String email) {
        userService.editUser(username, email);
    }

    public UserResponse getDetailedUserInfo(String username) {
        User user = userService.getDetailedUserInfo(username);
        return userMapper.userToUserResponse(user);
    }
}
