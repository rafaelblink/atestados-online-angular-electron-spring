package com.atestados.online.AtestadosOnline.Security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtCreator.class);

    public String create(Authentication authentication) {

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 860_000_000);

        return Jwts.builder()
                .setSubject(Long.toString(userDetailsImpl.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, "TravisScott")
                .compact();
    }

    Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey("TravisScott")
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    boolean validate(String authToken) {
        try {
            Jwts.parser().setSigningKey("TravisScott").parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            LOGGER.error("Assinatura JWT inválida");
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT mal formado");
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expirado");
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT não suportado");
        } catch (IllegalArgumentException ex) {
            LOGGER.error("JWT argumento ilegal");
        }
        return false;
    }
}

