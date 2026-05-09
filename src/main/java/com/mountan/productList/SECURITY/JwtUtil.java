package com.mountan.productList.SECURITY;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Component
public class JwtUtil {

    // Base64-encoded secret key used for signing JWTs (HS256 requires at least 256-bit key)
    // NOTE: In production, you should NOT generate this randomly on each startup.
    //       Store a fixed secret in application properties or an environment variable.
    private static String secretKey;

    // Constructor runs once when Spring creates this bean.
    // It generates a new random 256‑bit key and encodes it as Base64 string.
    JwtUtil() {
        SecureRandom random = new SecureRandom();  // cryptographically secure random generator
        byte[] key = new byte[32];                 // 32 bytes = 256 bits for HS256
        random.nextBytes(key);                     // fill array with random bytes
        secretKey = Base64.getEncoder().encodeToString(key); // store as Base64 string
    }

    // Generate JWT token for a given username and list of roles
    public String generateToken(String username, List<String> roles) {
        // Build JWT with subject, custom "roles" claim, issue date and expiration
        return Jwts.builder()
                .setSubject(username)                         // "sub" claim: who the token belongs to
                .claim("roles", roles)                        // custom claim: user roles
                .setIssuedAt(new Date(System.currentTimeMillis())) // token creation time
                // token expiry time: now + 2 minutes (1000 ms * 60 * 2)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2))
                // sign JWT with HMAC-SHA256 using our secret key
                .signWith(getSignedKey(), SignatureAlgorithm.HS256)
                .compact();                                   // build final token string
    }

    // Convert the Base64-encoded secretKey into a Key object usable by JJWT
    private Key getSignedKey() {
        // Decode from Base64 string to raw bytes
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        // Create a Key suitable for HMAC-SHA algorithms (HS256 in our case)

        return Keys.hmacShaKeyFor(keyBytes);
    }

// check validation expiration token and time
    public boolean validToken(String token, String username ){

        return (extractUsername(token).equals(username)) && !isTokenIsExpiration(token);
    }

    public  String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }

    public  Date  extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    public Boolean isTokenIsExpiration(String token){
        return extractExpiration(token).before(new Date());
    }

    public List<String> extractRole(String token){
        return extractClaim(token,claims -> claims.get("roles" , List.class));
    }


    public <T> T extractClaim(String token , Function<Claims,T> claimsResolver){
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSignedKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }
}