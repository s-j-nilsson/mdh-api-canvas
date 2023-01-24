package se.mdh.api.canvas;

import javax.servlet.ServletContextListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import se.mdh.servlet.ApplicationListener;

@SpringBootApplication
public class CanvasApiApplication {
  public static void main(final String[] args) {
    SpringApplication.run(CanvasApiApplication.class, args);
  }

  @Bean
  ServletListenerRegistrationBean<ServletContextListener> myServletListener() {
    ServletListenerRegistrationBean<ServletContextListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
    servletListenerRegistrationBean.setListener(new ApplicationListener());
    return servletListenerRegistrationBean;
  }
}
