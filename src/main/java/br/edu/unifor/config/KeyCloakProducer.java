package br.edu.unifor.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

@ApplicationScoped
public class KeyCloakProducer {

    @Produces
    public Keycloak produceKeycloak(String authorization) {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .realm("unifor")
                .username("admin")
                .password("admin")
                .clientId("teste-unifor")
                //.authorization(authorization)
                .clientSecret("BeolEfCE1ZHDQksG6aK7i0JsNs3PuQcv")
                .build();
    }

}
