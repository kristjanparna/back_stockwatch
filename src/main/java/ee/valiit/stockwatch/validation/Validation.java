package ee.valiit.stockwatch.validation;

import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
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

    public static void validateEmailExists(String email, List<Contact> contacts) {
        for (Contact contact : contacts) {
            if (email.equals(contact.getEmail())) {
                throw new BusinessException(StockwatchError.EMAIL_EXISTS.getMessage(), StockwatchError.EMAIL_EXISTS.getErrorCode());
            }
        }
    }

    public static void validateUserIsActive(User user) {
        if (!user.getRole().getType().equals("admin") && user.getContact().getEnd() != null) {
            throw new BusinessException(StockwatchError.INACTIVE_USER.getMessage(), StockwatchError.INACTIVE_USER.getErrorCode());
        }
    }

    public static void validateTickerExists(List<Instrument> allInstruments, String ticker) {
        for (Instrument instrument : allInstruments) {
            if (instrument.getTicker().equals(ticker)) {
                throw new BusinessException(StockwatchError.TICKER_EXISTS.getMessage(), StockwatchError.TICKER_EXISTS.getErrorCode());
            }
        }
    }

    public static void validateTickerNotInWatchlist(List<Instrument> allInstruments, String ticker) {
        for (Instrument instrument : allInstruments) {
            if (instrument.getTicker().equals(ticker)) {
                throw new BusinessException(StockwatchError.TICKER_IN_WATCHLIST.getMessage(), StockwatchError.TICKER_IN_WATCHLIST.getErrorCode());
            }
        }
    }

    public static void validateTickerNotInPortfolio(List<Instrument> allInstruments, String ticker) {
        for (Instrument instrument : allInstruments) {
            if (instrument.getTicker().equals(ticker)) {
                throw new BusinessException(StockwatchError.TICKER_IN_PORTFOLIO.getMessage(), StockwatchError.TICKER_IN_PORTFOLIO.getErrorCode());
            }
        }
    }
}
