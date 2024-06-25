package CoinKeeper.configuration.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import CoinKeeper.service.usuario.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

    @Value("${coinkeeper.jwtSecret}")
    private String jwtSecret; // password

    @Value("${coinkeeper.jwtExpirationMs}")
    private int jwtExpirationMs; // tempo que o token vai ficar válido

    public String generateTokenFromUserDetailsImp(UserDetailsImpl userDetails) {
        return buildJwtToken(userDetails.getUsername(), jwtExpirationMs);
    }

    private String buildJwtToken(String subject, long expirationMs) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);

        Key key = getSigningKey();

        return Jwts.builder()
                .subject(subject)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(key)
                .compact();
    }

    private SecretKey getSigningKey() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }

    public boolean validateJwtToken(String authToken) {

        try {
            Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(authToken).getPayload();
            return true;

        } catch (MalformedJwtException e) {
            System.out.println("Token inválido. " + e.getMessage());

        } catch (ExpiredJwtException e) {
            System.out.println("Token expirado. " + e.getMessage());

        } catch (UnsupportedJwtException e) {
            System.out.println("Token não suportado. " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Argumento inválido. " + e.getMessage());

        }

        return false;
    }

    public String getUsernameToken(String token){
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }
}
