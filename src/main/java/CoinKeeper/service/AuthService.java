package CoinKeeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    JdbcTemplate jdbcTemplate;

    public AuthenticationResponseDTO login(AuthenticationRequestDTO authDTO) {
        try {
            if(loginExits(authDTO.getUsername()))
                return new AuthenticationResponseDTO("-1");

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

        return null;
    }

    private boolean loginExits(String login) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE login = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, login);
        return count == null || count == 0;
    }

    private boolean senhaExists(String login) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE login = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, login);
        return count == null || count == 0;
    }
}
