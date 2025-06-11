package org.example.healthcare.config;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

//import static java.security.KeyRep.Type.SECRET;

@Service
public class JwtUtil {

    private final String secret = "secre983239842iejwdoijedwe9203i4234ijdwoeijwd092i340234joiwdjeowj029i34203djowidt";

    public String generateToken(String username) {
         return Jwts.builder().setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, String.valueOf(secret))
                .compact();
    }

    public String extractuserName(String jwttoken) {
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(jwttoken)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String jwttoken) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(jwttoken);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
