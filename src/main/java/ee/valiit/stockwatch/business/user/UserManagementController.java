package ee.valiit.stockwatch.business.user;


import ee.valiit.stockwatch.business.user.register.RegisterRequest;
import ee.valiit.stockwatch.domain.user.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

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
        userManagementService.addUser(registerRequest);
    }

    @GetMapping("/userinfo")
    @Operation(summary = "Leiab kasutajate info admin paneeli tabelisse")
    public List<UserResponse> getUsersInfo() {
        List<UserResponse> usersInfo = userManagementService.getUsersInfo();
        return usersInfo;
    }

    @PutMapping("/remove")
    @Operation(summary = "Lisab kontakti tabelisse end date kuupäeva, kasutaja muutub mitteaktiivseks")
    public void deactivateUser(String username) {
        userManagementService.deactivateUser(username);


        // todo:        saame kätte kasutajanime ja lõpu kuupäeva.
        //              kasutaja järgi leiame üles contactId ja lisame contact tabeli vastavale reale endDate'i
        //              contact tabelile saab ligi läbi User entity. Läbi UserManagementService kihi pöördume
        //              UserService poole kust saame ligi UserRepositoryle

        // todo:        kasutaja lõplikuks eemaldamiseks on vaja ka user tabelisse lõpukuupäeva, muidu saab endiselt
        //              sisse logida. Äkki saab userValidationisse panna lisaks ühe tingimuse - sisse saab logida,
        //              kui endDate != null
    }
}
