package br.edu.unifor.controller;

import br.edu.unifor.dto.ProfessorDTO;
import br.edu.unifor.service.ProfessorService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;


@Path("/v1/professores")
@ApplicationScoped
//@RolesAllowed({"admin", "coord"})
public class ProfessorController {

    @Inject
    public ProfessorService professorService;

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
    public Response getProfessores() {

        return Response.ok(professorService.getProfessores()).build();
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
    public Response getProfessorDetalhado(@PathParam(value = "id") Long id) {

        return Response.ok(professorService.getProfessorById(id)).build();
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
    public Response inserirProfessor(ProfessorDTO professorDTO) {

        professorService.inserirProfessor(professorDTO);

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
    public Response atualizarProfessor(@PathParam(value = "id") Long id, ProfessorDTO professorDTO) {

        professorDTO = professorService.atualizarProfessor(id, professorDTO);

        return Response.ok(professorDTO).build();
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
    public Response excluirProfessor(@PathParam(value = "id") Long id) {

        professorService.excluirProfessor(id);

        return Response.ok().build();
    }

}
