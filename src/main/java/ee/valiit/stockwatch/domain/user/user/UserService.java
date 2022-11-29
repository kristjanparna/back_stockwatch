package ee.valiit.stockwatch.domain.user.user;

import ee.valiit.stockwatch.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User getValidUser(String username, String password) {
        Optional<User> userOptional = userRepository.findUserBy(username, password);
        Validation.validateUserCredentials(userOptional);
        return userOptional.get();
    }

    public void addUser(User user) {
        List<User> allUsers = userRepository.findAll();
        Validation.validateUsernameExists(user, allUsers);
        userRepository.save(user);
    }

    public List<User> getUsersInfo() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }
}
