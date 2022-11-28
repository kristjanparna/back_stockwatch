package ee.valiit.stockwatch.user.login;


import ee.valiit.stockwatch.user.register.RegisterRequest;
import ee.valiit.stockwatch.user.register.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import org.mapstruct.Mapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @Resource
    private RegisterService registerService;

    @GetMapping("/login")
    @Operation(summary = "Sisselogimise teenus")
    public LoginResponse login (@RequestParam String username, @RequestParam String password) {
        LoginResponse login = loginService.login(username, password);
        return login;
    }
    @PostMapping("/register")
    @Operation(summary = "Registreerimise teenus")
    public void register (@RequestParam RegisterRequest registerRequest) {
        registerService.addUser(registerRequest);
    }
}
