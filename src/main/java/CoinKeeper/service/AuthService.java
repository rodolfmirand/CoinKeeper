package CoinKeeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import CoinKeeper.dto.request.AuthenticationRequestDTO;
import CoinKeeper.dto.response.AuthenticationResponseDTO;
import CoinKeeper.security.jwt.JwtUtils;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AuthenticationResponseDTO login(AuthenticationRequestDTO authDTO) {

        try {
            // cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(
                    authDTO.getUsername(), authDTO.getPassword());

            // prepara mecanismo para autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);

            // busca usuario logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImp(userAuthenticate);

            return new AuthenticationResponseDTO(token);
        } catch (BadCredentialsException e) {
            System.out.println(" " + e.getMessage());
        }

        return new AuthenticationResponseDTO(null);
    }
}
