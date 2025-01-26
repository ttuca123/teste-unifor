package br.edu.unifor.controller;

import br.edu.unifor.config.KeyCloakProducer;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import org.jboss.logging.Logger;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RoleRepresentation;

import java.util.List;

@Path("/api/admin")
@ApplicationScoped
public class RolesController {



    @Inject
    KeyCloakProducer keyCloakProducer;

    @GET
    @Path("/roles")
    public List<RoleRepresentation> getRoles() {

        //logger.debug("log roles");
        System.out.println("log roles");

        Keycloak keycloak = keyCloakProducer.produceKeycloak("");

        return keycloak.realm("unifor").roles().list();
    }

}
