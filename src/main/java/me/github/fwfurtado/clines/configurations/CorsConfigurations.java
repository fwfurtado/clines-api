package me.github.fwfurtado.clines.configurations;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class CorsConfigurations implements WebMvcConfigurer {

    private final CorsConfigurationProperties corsProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/")
                .allowedOrigins(corsProperties.getOrigins())
                .allowedMethods(corsProperties.getHeaders())
                .allowedHeaders(corsProperties.getHeaders())
                .allowCredentials(corsProperties.isSendCredentials());
    }
}
