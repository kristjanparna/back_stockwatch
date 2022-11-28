package ee.valiit.stockwatch.business.user;

import ee.valiit.stockwatch.domain.user.user.User;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class LoginResponse implements Serializable {
    private final Integer userId;
    private final Integer roleId;
}