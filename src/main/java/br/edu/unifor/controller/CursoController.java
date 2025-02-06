package br.edu.unifor.controller;

import br.edu.unifor.dto.CursoDTO;
import br.edu.unifor.dto.DisciplinaDTO;
import br.edu.unifor.service.CursoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;

@Path("/v1/cursos")
//@RolesAllowed({"admin", "coord"})
@ApplicationScoped
public class CursoController {

    @Inject
    public CursoService cursoService;

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
    @CircuitBreaker
    @Retry(maxRetries = 1)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCursos() {

        return Response.ok(cursoService.getCursos()).build();
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
    public Response getCursoDetalhado(@PathParam(value = "id") Long id) {


        return Response.ok(cursoService.getCursoById(id)).build();
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
    public Response inserirCurso(CursoDTO cursoDTO) {

        cursoService.inserirCurso(cursoDTO);

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
    public Response atualizarCurso(@PathParam(value = "id") Long id, CursoDTO cursoDTO) {


        cursoDTO = cursoService.atualizarCurso(id, cursoDTO);

        return Response.ok(cursoDTO).build();
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
    public Response excluirCurso(@PathParam(value = "id") Long id) {

        cursoService.excluirCurso(id);

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
    @POST
    @CircuitBreaker
    @Retry(maxRetries = 3)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserirMatrizCurricular(CursoDTO cursoDTO) {

        cursoService.inserirCurso(cursoDTO);

        return Response.ok().build();
    }

}
