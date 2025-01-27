package br.edu.unifor.config;

import br.edu.unifor.dto.AuthDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

@ApplicationScoped
public class KeyCloakProducer {

    @Produces
    public Keycloak produceKeycloak() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .realm("unifor")
                .username("admin")
                .password("admin")
                .clientId("testeunifor")
                .clientSecret("w3Mw76dsi3vWSRQwwbClGBWgmpOS5VfY")
                .build();
    }


    @Produces
    public Keycloak produceKeycloak(AuthDTO authDTO) {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .realm("unifor")
                .username(authDTO.getUser())
                .password(authDTO.getPassword())
                .clientId("testeunifor")
                .clientSecret("w3Mw76dsi3vWSRQwwbClGBWgmpOS5VfY")
                .build();
    }

}
