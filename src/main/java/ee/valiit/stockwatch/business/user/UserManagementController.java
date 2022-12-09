package ee.valiit.stockwatch.business.user;


import ee.valiit.stockwatch.business.user.login.LoginResponse;
import ee.valiit.stockwatch.business.user.register.RegisterRequest;
import ee.valiit.stockwatch.domain.user.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserManagementController {

    @Resource
    private UserManagementService userManagementService;


    @GetMapping("/login")
    @Operation(summary = "Sisselogimise teenus")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        return userManagementService.login(username, password);
    }

    @PostMapping("/register")
    @Operation(summary = "Registreerimise teenus")
    public void register(@RequestBody RegisterRequest registerRequest) {
        userManagementService.addUser(registerRequest);
    }

    @GetMapping("/userinfo")
    @Operation(summary = "Leiab kasutajate info admin paneeli tabelisse")
    public List<UserResponse> getUsersInfo() {
        return userManagementService.getUsersInfo();
    }

    @GetMapping("/userinfo/detail")
    @Operation(summary = "Tagastab ühe kasutaja andmed admin paneeli")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Kasutaja leitud"),
            @ApiResponse(responseCode = "404", description = "Sisestatud kasutajanime ei leitud")
    })
    public UserResponse getDetailedUserInfo(String username) {
        return userManagementService.getDetailedUserInfo(username);
    }

    @PutMapping("/remove")
    @Operation(summary = "Lisab kontakti tabelisse end date kuupäeva, kasutaja muutub mitteaktiivseks")
    public void removeUser(String username) {
        userManagementService.deactivateUser(username);
    }

    @PutMapping("/userinfo")
    @Operation(summary = "Muudab kasutaja kontaktinfot")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Muudab kasutaja kontaktandmetes e-posti aadressi"),
            @ApiResponse(responseCode = "403", description = "Sisestatud e-posti aadress on juba kasutuses")
    })
    public String editUser(@RequestParam String username, @RequestParam String email) {
        userManagementService.editUser(username, email);
        return "E-post muudetud";
    }

}
