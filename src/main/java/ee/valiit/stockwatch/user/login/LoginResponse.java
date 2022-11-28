package ee.valiit.stockwatch.user.login;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ee.valiit.stockwatch.user.login.User} entity
 */
@Data
public class LoginResponse implements Serializable {
    private final Integer userId;
    private final Integer roleId;
}