package ee.valiit.stockwatch.business.user.register;

import ee.valiit.stockwatch.domain.user.user.User;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class RegisterRequest implements Serializable {

    @Size(max = 50)
    @NotNull
    private final String contactFirstName;
    @Size(max = 50)
    @NotNull
    private final String contactLastName;
    @Size(max = 255)
    @NotNull
    private final String contactEmail;
    @Size(max = 50)
    @NotNull
    private final String username;
    @Size(max = 50)
    @NotNull
    private final String password;
}