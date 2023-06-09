package com.hufflepuff.generation.italy.BookIn.model.services.abstractions;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface AbstractJwtService {
   String extractUsername(String token);

   <T> T extractClaim (String token, Function<Claims, T> claimseResolver);

   Claims extractAllClaims(String token);

   Key getSignInKey();

   String generateToken(UserDetails userDetails);

   String generateToken(
         Map<String, Object> extraClaims,
         UserDetails userDetails
   );

   String generateRefreshToken(UserDetails userDetails);

   String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, long expiration);

   boolean isTokenValid(String token, UserDetails userDetails);

   boolean isTokenExpired(String token);

   Date extractExpiration(String token);
}
