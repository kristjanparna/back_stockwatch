package ee.valiit.stockwatch.user.register;


import ee.valiit.stockwatch.user.login.User;
import ee.valiit.stockwatch.user.user.UserMapper;
import ee.valiit.stockwatch.user.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class RegisterService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    @Resource
    private RegisterMapper registerMapper;

    @Resource
    private ContactMapper contactMapper;

    public void addUser(RegisterRequest registerRequest) {
        User user = registerMapper.registerRequestToUser(registerRequest);
        userRepository.save(user);

//        Contact contact = contactMapper.registerRequestToContact(registerRequest);
//        contact.setFirstName(registerRequest.getContactFirstName());
//        contact.setLastName(registerRequest.getContactLastName());
//        contact.setEmail(registerRequest.getContactEmail());
//        user.setContact(contact);
//        userRepository.save(user);


    }


}
