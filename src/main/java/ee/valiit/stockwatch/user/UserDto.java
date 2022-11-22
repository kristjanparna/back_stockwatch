package ee.valiit.stockwatch.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Integer id;
    @Size(max = 50)
    @NotNull
    private final String username;
    @Size(max = 50)
    @NotNull
    private final String password;
}