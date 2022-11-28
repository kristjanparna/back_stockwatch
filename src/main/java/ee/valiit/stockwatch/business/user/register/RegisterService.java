package ee.valiit.stockwatch.business.user.register;


import ee.valiit.stockwatch.domain.user.contact.ContactMapper;
import ee.valiit.stockwatch.domain.user.user.User;
import ee.valiit.stockwatch.domain.user.user.UserMapper;
import ee.valiit.stockwatch.domain.user.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterService {


    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ContactMapper contactMapper;




}
