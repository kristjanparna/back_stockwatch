package ee.valiit.stockwatch.domain.user.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserResponse implements Serializable {
    @Size(max = 50)
    @NotNull
    private final String username;
    @Size(max = 50)
    @NotNull
    private final String firstname;
    @Size(max = 50)
    @NotNull
    private final String lastname;
    @Size(max = 255)
    @NotNull
    private final String email;
    @NotNull
    private final LocalDate startDate;
}
