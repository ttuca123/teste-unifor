package br.edu.unifor.controller;

import br.edu.unifor.dto.DisciplinaDTO;
import br.edu.unifor.service.DisciplinaService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;

@Path("/v1/disciplinas")
@ApplicationScoped
//@RolesAllowed({"admin", "coord"})
public class DisciplinaController {

    @Inject
    public DisciplinaService disciplinaService;

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
    public Response getDisciplinas() {

        return Response.ok(disciplinaService.getDisciplinas()).build();
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
    public Response getDisciplinaDetalhada(@PathParam(value = "id") Long id) {

        return Response.ok(disciplinaService.getDisciplinaById(id)).build();
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
    public Response inserirDisciplina(DisciplinaDTO disciplinaDTO) {

        disciplinaService.inserirDisciplina(disciplinaDTO);

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
    public Response atualizarDisciplina(@PathParam(value = "id") Long id, DisciplinaDTO disciplinaDTO) {

        disciplinaDTO = disciplinaService.atualizarDisciplina(id, disciplinaDTO);

        return Response.ok(disciplinaDTO).build();
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
    public Response excluirDisciplina(@PathParam(value = "id") Long id) {

        disciplinaService.excluirDisciplina(id);

        return Response.ok().build();
    }

}
