package br.edu.unifor.controller;

import br.edu.unifor.config.KeyCloakProducer;
import br.edu.unifor.dto.AuthDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.auth.LoginConfig;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;


@Path("/v1/auth")
@ApplicationScoped
public class AuthController {

    @Inject
    KeyCloakProducer keyCloakProducer;


    /** Endpoint responsável por obter o token
     * de autorização dos endpoints protegidos
     *
     * @author Artur
     * @param user
     * @return
     */
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public AccessTokenResponse login(AuthDTO user) {

       Keycloak keycloak = keyCloakProducer.produceKeycloak(user);

        AccessTokenResponse token = null;
        try {
                token = keycloak.tokenManager().getAccessToken();
            } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return token;

    }


}
