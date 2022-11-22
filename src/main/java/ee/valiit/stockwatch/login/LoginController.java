package ee.valiit.stockwatch.login;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {



    @GetMapping("/login")
    @Operation(summary = "Logib teenusesse sisse")
    public void login(String username, String password) {

    }
}
