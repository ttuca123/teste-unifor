package br.edu.unifor.config;

import br.edu.unifor.dto.AuthDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KeyCloakProducer {

    private static final String REALM = "unifor";
    private static final String URL = "http://localhost:8080";
    private static final String CLIENT_ID = "teste-unifor";
    private static final String CLIENT_SECRET = "OvaeyZokmz5EPOTK0U25gipe3XWzst95";
    private static final Logger logger = LoggerFactory.getLogger(KeyCloakProducer.class);

    @Produces
    public Keycloak produceKeycloak() {
        return KeycloakBuilder.builder()
                .serverUrl(URL)
                .realm(REALM)
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .build();
    }


    @Produces
    public Keycloak produceKeycloak(AuthDTO authDTO) {

        logger.info("Building Keycloak client for user: {}", authDTO.getUser());
        return KeycloakBuilder.builder()
                .serverUrl(URL)
                .realm(REALM)
                .username(authDTO.getUser())
                .password(authDTO.getPassword())
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .build();
    }

}
