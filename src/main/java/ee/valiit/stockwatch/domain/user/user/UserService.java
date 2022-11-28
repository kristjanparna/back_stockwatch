package ee.valiit.stockwatch.domain.user.user;

import ee.valiit.stockwatch.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User getValidUser (String username, String password) {
        Optional<User> userOptional = userRepository.findUserBy(username, password);
        Validation.validateUserCredentials(userOptional);
        User user = userOptional.get();
        return user;
    }

    public void addUser(User user) {
        // TODO: Validate that the username does not exist
        userRepository.save(user);
    }
}
