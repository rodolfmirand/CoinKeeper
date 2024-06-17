package CoinKeeper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CoinKeeper.dto.request.AuthenticationRequestDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDTO authDTO) {

    }
}
