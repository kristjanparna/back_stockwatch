package ee.valiit.stockwatch.business.user;


import ee.valiit.stockwatch.business.user.register.RegisterRequest;
import ee.valiit.stockwatch.business.user.register.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserManagementController {

    @Resource
    private UserManagementService userManagementService;


    @GetMapping("/login")
    @Operation(summary = "Sisselogimise teenus")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        LoginResponse login = userManagementService.login(username, password);
        return login;
    }

    @PostMapping("/register")
    @Operation(summary = "Registreerimise teenus")
    public void register(@RequestBody RegisterRequest registerRequest) {
        userManagementService.addContact(registerRequest);
        userManagementService.addUser(registerRequest);
    }
}
