package br.edu.unifor.controller;

import br.edu.unifor.dto.CursoDTO;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;

@Path("/v1/matriz-curricular")
@ApplicationScoped
public class MatrizCurricularController {

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
    @RolesAllowed({"admin", "coord"})
    public Response inserirMatrizCurricular(CursoDTO cursoDTO) {

        //cursoService.inserirCurso(cursoDTO);

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
    @GET
    @CircuitBreaker
    @Retry(maxRetries = 3)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "coord", "prof", "aluno"})
    public Response visualizarMatrizCurricular() {

        //cursoService.inserirCurso(cursoDTO);

        return Response.ok().build();
    }

}
