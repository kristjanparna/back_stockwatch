package ee.valiit.stockwatch.domain.user.contact;


import ee.valiit.stockwatch.business.user.register.RegisterRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }
}
