package CoinKeeper.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import CoinKeeper.configuration.jwt.JwtUtils;
import CoinKeeper.dto.request.AuthenticationRequest;
import CoinKeeper.model.user.User;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String login(AuthenticationRequest authDTO) {
        try {
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(
                    authDTO.getLogin(), authDTO.getPassword()); // cria mecanismo de credencial para o spring
            Authentication authentication = authenticationManager.authenticate(userAuth); // prepara mecanismo para
                                                                                          // autenticação
            User userAuthenticate = (User) authentication.getPrincipal(); // busca usuario logado

            return jwtUtils.generateTokenFromUserDetailsImp(userAuthenticate);

        } catch (BadCredentialsException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
