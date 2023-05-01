package com.hufflepuff.generation.italy.BookIn.model.services.abstractions;

import com.hufflepuff.generation.italy.BookIn.model.entities.User;
import com.hufflepuff.generation.italy.BookIn.model.utils.auth.AuthenticationRequest;
import com.hufflepuff.generation.italy.BookIn.model.utils.auth.AuthenticationResponse;
import com.hufflepuff.generation.italy.BookIn.model.utils.auth.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AbstractAuthenticationService {
   AuthenticationResponse register(RegisterRequest request);

   void saveUserToken(User user, String jwtToken);

   void revokeAllUserTokens(User user);

   void refreshToken(HttpServletRequest request,
                     HttpServletResponse response) throws IOException;

   AuthenticationResponse authenticate(AuthenticationRequest request);
}
