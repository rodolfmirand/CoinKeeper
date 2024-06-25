package CoinKeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok().body(authService.login(authDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerNewUser(@RequestBody UsuarioRequestDTO user) {
        return ResponseEntity.ok().body(userService.registerNewUser(user));
    }
}
