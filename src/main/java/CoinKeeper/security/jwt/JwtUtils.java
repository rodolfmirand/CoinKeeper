package CoinKeeper.security.jwt;

import java.nio.charset.MalformedInputException;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import CoinKeeper.service.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

    @Value("${CoinKeeper.jwtSecret}")
    private String jwtSecret; // password

    @Value("${CoinKeeper.jwtExpirationMs}")
    private int jwtExpirationMs; // tempo que o token vai ficar válido

    public String generateTokenFromUserDetailsImp(UserDetailsImpl userDetails) {
        return buildJwtToken(userDetails.getUsername(), jwtExpirationMs);
    }

    private String buildJwtToken(String subject, long expirationMs) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);

        Key key = getSigningKey();

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    private Key getSigningKey() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }

    private boolean validateJwtToken(String authToken) {

        try {
            Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(authToken);
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
}
