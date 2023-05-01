package com.hufflepuff.generation.italy.BookIn.model.utils.securityConfig;

import com.hufflepuff.generation.italy.BookIn.model.data.abstractions.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor // crea un costruttore per tutti i campi final
public class ApplicationConfig {

  private final UserRepository repository;

  //L'Autowired c'è ma non si vede:
  // Lombok crea il costruttore
  // Spring di default fa' Dependency Injection sul costruttore

  @Bean
  public UserDetailsService userDetailsService() { // la lambda qui crea una classe anonima che implementa UserDetailsService
      // ^ la lambda fa' @Override del metodo dell'interfaccia qui sopra (loadUserByUsername())
    return username -> repository.findByEmail(username) // la lambda può stare dopo un return (!) tanto noi ritorniamo un'istanza della classe anonima, non la funzione in sé (non siamo su JS)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(); // classe legacy, oggi il DAO si chiama Repository
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder()); // passwordEncoder() si occupa dell'hashing della password
    return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager(); // ce l'ha già il framework AuthenticationConfiguration, noi lo prendiamo soltanto
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
