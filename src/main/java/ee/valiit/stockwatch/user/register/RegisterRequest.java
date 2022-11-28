package ee.valiit.stockwatch.user.register;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link ee.valiit.stockwatch.user.login.User} entity
 */
@Data
public class RegisterRequest implements Serializable {

//    @Size(max = 50)
//    @NotNull
//    private final String contactFirstName;
//    @Size(max = 50)
//    @NotNull
//    private final String contactLastName;
//    @Size(max = 255)
//    @NotNull
//    private final String contactEmail;
    @Size(max = 50)
    @NotNull
    private final String username;
    @Size(max = 50)
    @NotNull
    private final String password;
}