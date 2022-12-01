package ee.valiit.stockwatch.validation;

import lombok.Getter;

@Getter
public enum StockwatchError {
    INCORRECT_CREDENTIALS("Sellist kasutajanime või parooli ei leitud.", "001"),
    USERNAME_EXISTS("Selle nimega kasutaja on juba registreeritud, palun vali uus kasutajanimi.", "002"),
    EMAIL_EXISTS("See meiliaadress on juba kasutusel.", "003"),
    INACTIVE_USER("See kasutaja on deaktiveeritud", "004"),
    CANNOT_DEACTIVATE_ADMIN("Administraatori kontot ei saa deaktiveerida", "005"),
    TICKER_EXISTS("Ühte instrumenti ei saa tabelisse kaks korda lisada", "006"),
    TICKER_IN_WATCHLIST("See instrument on juba lisatud sinu nimekirja", "007");

    private final String message;
    private final String errorCode;

    StockwatchError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
