package CoinKeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CoinKeeper.dto.request.AuthenticationRequestDTO;
import CoinKeeper.dto.request.UsuarioRequestDTO;
import CoinKeeper.service.autenticacao.AuthService;
import CoinKeeper.service.usuario.UsuarioService;

@RestController
@RequestMapping("/coinkeeper/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDTO authDTO) {
        if (userService.verifyLogin(authDTO.getLogin()))
            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, authService.login(authDTO).toString())
                    .body("Login bem sucedido.");

        return ResponseEntity.badRequest().body("Este login não existe.");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerNewUser(@RequestBody UsuarioRequestDTO user) {
        if (userService.verifyLogin(user.getLogin()))
            return ResponseEntity.badRequest().body("Login já cadastrado.");

        if (userService.verifyEmail(user.getEmail()))
            return ResponseEntity.badRequest().body("E-mail já cadastrado.");

        return ResponseEntity.ok().body(userService.registerNewUser(user));
    }
}
