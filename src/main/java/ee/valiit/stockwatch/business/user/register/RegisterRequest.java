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
    private String firstname;
    @Size(max = 50)
    @NotNull
    private String lastname;
    @Size(max = 255)
    @NotNull
    private String email;
    @Size(max = 50)
    @NotNull
    private String username;
    @Size(max = 50)
    @NotNull
    private String password;
}