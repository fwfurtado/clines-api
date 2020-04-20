package me.github.fwfurtado.clines.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "cors.allowed")
@Getter
@Setter
public class CorsConfigurationProperties {
    private List<String> origins = List.of();
    private List<String> headers = List.of();
    private List<HttpMethod> methods = List.of(HttpMethod.HEAD, HttpMethod.GET);
    private boolean sendCredentials;
    private boolean allMethods;


    public void setMethods(List<HttpMethod> methods) {
        if (allMethods) {
            this.methods = List.of(HttpMethod.values());
            return;
        }

        this.methods = methods;
    }

    public String[] getOrigins() {
        return origins.toArray(String[]::new);
    }

    public String[] getHeaders() {
        return headers.toArray(String[]::new);
    }

    public String[] getMethods() {
        return methods.stream().map(HttpMethod::name).toArray(String[]::new);
    }
}
