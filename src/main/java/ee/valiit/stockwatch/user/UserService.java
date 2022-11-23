package ee.valiit.stockwatch.user;

import com.fasterxml.jackson.databind.util.JSONPObject;
import ee.valiit.stockwatch.contact.Contact;
import ee.valiit.stockwatch.contact.ContactRepository;
import ee.valiit.stockwatch.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ContactRepository contactRepository;

    public User getValidUser(String username, String password) {
        Optional<User> userOptional = userRepository.findBy(username, password);
        Validation.validateUserCredentials(userOptional);
        User user = userOptional.get();
        return user;
    }




}
