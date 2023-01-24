package se.mdh.api.canvas.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * Konfiguration för applikationen.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppConfiguration {

  @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}") String jwkSetUri;

}


