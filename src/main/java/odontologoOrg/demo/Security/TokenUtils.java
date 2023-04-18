package odontologoOrg.demo.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class TokenUtils {

    private final static  String ACCESS_TOKEN_SECRET = "ProyectoOdontologicoparaeliminarlospapelesdelasfichas";
    private final static long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken (UserDetails userDetails){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS  * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String ,Object> extra = new HashMap<>();
        extra.put("name",userDetails);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken tokenAuthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email,null, Collections.emptyList());
        }catch (JwtException e){
            return null;
        }
        }




}
