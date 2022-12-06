package ee.valiit.stockwatch.business.watchlist.contact;


import ee.valiit.stockwatch.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    public void addContact(Contact contact) {
        List<Contact> contacts = contactRepository.findAll();
        Validation.validateEmailExists(contact, contacts);
        contactRepository.save(contact);
    }
}
