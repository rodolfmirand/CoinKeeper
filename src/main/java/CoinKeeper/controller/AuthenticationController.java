package CoinKeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CoinKeeper.dto.request.AuthenticationRequest;
import CoinKeeper.dto.request.UserRequest;
import CoinKeeper.service.authentication.AuthService;
import CoinKeeper.service.cookie.CookieService;
import CoinKeeper.service.user.UserService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/coinkeeper/auth")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    //aberto
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authRequest, HttpServletResponse response) {
        if (userService.verifyLogin(authRequest.getLogin())) {
            String token = authService.login(authRequest);
            if (token != null) {
                CookieService.setCookie(token, response);
                return ResponseEntity.ok()
                        .body("Login bem sucedido.");
            } else {
                return ResponseEntity.badRequest().body("Senha incorreta.");
            }
        }
        return ResponseEntity.badRequest().body("Login não encontrado.");
    }

    //aberto
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
        if (userService.verifyLogin(userRequest.getLogin()))
            return ResponseEntity.badRequest().body("Login já cadastrado.");

        if (userService.verifyEmail(userRequest.getEmail()))
            return ResponseEntity.badRequest().body("E-mail já cadastrado.");

        return ResponseEntity.ok().body(userService.register(userRequest));
    }
}
