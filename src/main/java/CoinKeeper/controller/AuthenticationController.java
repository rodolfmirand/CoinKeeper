package CoinKeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CoinKeeper.dto.request.AuthenticationRequest;
import CoinKeeper.dto.request.UserRequest;
import CoinKeeper.service.authentication.AuthService;
import CoinKeeper.service.user.UserService;

@RestController
@RequestMapping("/coinkeeper/auth")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authRequest) {
        if (userService.verifyLogin(authRequest.getLogin()))
            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, authService.login(authRequest).toString())
                    .body("Login bem sucedido.");

        return ResponseEntity.badRequest().body("Login não encontrado.");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerNewUser(@RequestBody UserRequest userRequest) {
        if (userService.verifyLogin(userRequest.getLogin()))
            return ResponseEntity.badRequest().body("Login já cadastrado.");

        if (userService.verifyEmail(userRequest.getEmail()))
            return ResponseEntity.badRequest().body("E-mail já cadastrado.");

        return ResponseEntity.ok().body(userService.registerNewUser(userRequest));
    }
}
