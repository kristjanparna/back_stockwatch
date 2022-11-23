package ee.valiit.stockwatch.user;

import ee.valiit.stockwatch.contact.Contact;
import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    private String userId;
    private  String username;
    private String password;
    private List<Contact> contacts;
}
