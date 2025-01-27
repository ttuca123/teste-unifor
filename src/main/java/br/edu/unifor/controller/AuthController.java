package br.edu.unifor.controller;

import br.edu.unifor.config.KeyCloakProducer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.auth.LoginConfig;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;


@Path("/v1/auth")
@ApplicationScoped
public class AuthController {

    @Inject
    KeyCloakProducer keyCloakProducer;



    @GET
    @Path("/roles")
    public List<RoleRepresentation> login() {

       Keycloak keycloak = keyCloakProducer.produceKeycloak();

        return keycloak.realm("unifor").roles().list();
    }


}
