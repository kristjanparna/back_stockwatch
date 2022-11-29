package ee.valiit.stockwatch.validation;

import ee.valiit.stockwatch.domain.user.contact.Contact;
import ee.valiit.stockwatch.domain.user.user.User;
import ee.valiit.stockwatch.infrastructure.exception.BusinessException;

import java.util.List;
import java.util.Optional;

public class Validation {

    public static void validateUserCredentials(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(StockwatchError.INCORRECT_CREDENTIALS.getMessage(),
                    StockwatchError.INCORRECT_CREDENTIALS.getErrorCode());
        }
    }

    public static void validateUsernameExists(User user, List<User> userList) {
        for (User firstUser : userList) {
            if (firstUser.getUsername().equals(user.getUsername())) {
                throw new BusinessException(StockwatchError.USERNAME_EXISTS.getMessage(), StockwatchError.USERNAME_EXISTS.getErrorCode());
            }
        }
    }

    public static void validateEmailExists(Contact contact, List<Contact> contacts) {
        for (Contact firstContact : contacts) {
            if (firstContact.getEmail().equals(contact.getEmail())) {
                throw new BusinessException(StockwatchError.EMAIL_EXISTS.getMessage(), StockwatchError.EMAIL_EXISTS.getErrorCode());
            }
        }
    }

}
