package br.edu.unifor.controller;

import br.edu.unifor.dto.UsuarioDTO;
import br.edu.unifor.service.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;

@Path("/v1/usuarios")
@ApplicationScoped
public class UsuarioController {

    @Inject
    public UsuarioService usuarioService;

    /**
     * O {@link Retry} garante que, em caso de erro, o método tentará ser executado
     * mais uma vez.
     * 
     * O {@link CircuitBreaker} Caso ocorram vários erros consecutivos, o
     * serviço para de responder imediatamente por
     * algum tempo enquanto se recupera.
     * 
     * 
     */
    @GET
    @Path("")
    @CircuitBreaker
    @Retry(maxRetries = 1)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {

        return Response.ok(usuarioService.getUsuarios()).build();
    }


    /**
     * O {@link Retry} garante que, em caso de erro, o método tentará ser executado
     * mais uma vez.
     *
     * O {@link CircuitBreaker} Caso ocorram vários erros consecutivos, o
     * serviço para de responder imediatamente por
     * algum tempo enquanto se recupera.
     *
     *
     */
    @GET
    @Path("/{id}")
    @CircuitBreaker
    @Retry(maxRetries = 1)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioDetalhado(@PathParam(value = "id") Long id) {

        return Response.ok(usuarioService.getUsuarioById(id)).build();
    }

    /**
     * O {@link Retry} garante que, em caso de erro, o método tentará ser executado
     * mais uma vez.
     * 
     * O {@link CircuitBreaker} Caso ocorram vários erros consecutivos, o
     * serviço para de responder imediatamente por
     * algum tempo enquanto se recupera.
     * 
     *
     */
    @POST
    @CircuitBreaker
    @Retry(maxRetries = 3)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserirUsuario(UsuarioDTO usuarioDTO) {

        usuarioService.inserirUsuario(usuarioDTO);

        return Response.ok().build();
    }

    /**
     * O {@link Retry} garante que, em caso de erro, o método tentará ser executado
     * mais uma vez.
     * 
     * O {@link CircuitBreaker} Caso ocorram vários erros consecutivos, o
     * serviço para de responder imediatamente por
     * algum tempo enquanto se recupera.
     * 
     *
     */
    @PUT
    @Path("/{id}")
    @CircuitBreaker
    @Retry(maxRetries = 3)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarUsuario(@PathParam(value = "id") Long id, UsuarioDTO usuarioDTO) {

        usuarioDTO = usuarioService.atualizarUsuario(id, usuarioDTO);

        return Response.ok(usuarioDTO).build();
    }

    /**
     * O {@link Retry} garante que, em caso de erro, o método tentará ser executado
     * mais uma vez.
     * 
     * O {@link CircuitBreaker} Caso ocorram vários erros consecutivos, o
     * serviço para de responder imediatamente por
     * algum tempo enquanto se recupera.
     * 
     *
     */
    @DELETE
    @Path("/{id}")
    @CircuitBreaker
    @Retry(maxRetries = 3)
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirUsuario(@PathParam(value = "id") Long id) {

        usuarioService.excluirUsuario(id);

        return Response.ok().build();
    }

}
