package ee.valiit.stockwatch.login;

import ee.valiit.stockwatch.infrastructure.error.ApiError;
import ee.valiit.stockwatch.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Logib teenusesse sisse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tagastab login objekti koos userId, username ja passwordiga - peaks tagastama userId ja roleId"),
            @ApiResponse(responseCode = "403", description = "Tagastab error objekti koos message ja errorCode väljdega", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public UserDto login(@RequestParam String username, @RequestParam String password) {
        UserDto login = loginService.login(username, password);
        return login;
    }
}
