package se.mdh.api.canvas.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@SecurityScheme(
    name = "Bearer Authentication",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer")
public class OAuth2LoginSecurityConfig {
  @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
  private String jwkUrl;

  @Bean
  @Profile("nosecurity")
  public SecurityFilterChain noSecurity(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeHttpRequests((authz) -> authz
            .anyRequest().permitAll()
        );
    return http.build();
  }

  @Bean
  @Profile("!nosecurity")
  public SecurityFilterChain security(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authz) -> authz
            .antMatchers("/v1/*").hasAuthority("SCOPE_public_api_read")
            .antMatchers("/actuator/health",
                         "/actuator/info",
                         "/v3/**",
                         "/configuration/ui",
                         "/swagger-resources/**",
                         "/configuration/security",
                         "/swagger-ui.html",
                         "/swagger-ui/**",
                         "/webjars/**").permitAll()
            .anyRequest().authenticated()
        )
        .oauth2ResourceServer()
        .jwt();
    return http.build();
  }
}
