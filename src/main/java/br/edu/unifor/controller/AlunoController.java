package br.edu.unifor.controller;

import java.util.List;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;

import br.edu.unifor.dto.AlunoDTO;
import br.edu.unifor.service.AlunoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/alunos")
@ApplicationScoped
public class AlunoController {

    @Inject
    public AlunoService alunoService;

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
    public Response getAlunos() {

        return Response.ok(alunoService.getAlunos()).build();
    }

}
