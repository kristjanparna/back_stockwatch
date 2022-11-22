package ee.valiit.stockwatch.validation;

import lombok.Getter;

@Getter
public enum StockwatchError {
    INCORRECT_CREDENTIALS("Sellist kasutajanime või parooli ei leitud", "001");

    private final String message;
    private final String errorCode;

    StockwatchError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
