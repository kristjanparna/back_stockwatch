package ee.valiit.stockwatch.validation;

import ee.valiit.stockwatch.infrastructure.exception.BusinessException;
import ee.valiit.stockwatch.user.User;

import java.util.Optional;

public class Validation {
    public static void validateUserCredentials(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(StockwatchError.INCORRECT_CREDENTIALS.getMessage(),
                    StockwatchError.INCORRECT_CREDENTIALS.getErrorCode());
        }
    }
}
