package br.edu.unifor.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.edu.unifor.dao.AlunoDAO;
import br.edu.unifor.dto.AlunoDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AlunoService {

    private final AlunoDAO alunoDAO;

    /**
     * @param alunoDAO
     * @param logger
     */
    @Inject
    public AlunoService(
            AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public List<AlunoDTO> getAlunos() {
        
        return alunoDAO.findAllAlunos().stream().map(aluno -> new AlunoDTO(aluno.getNome(),
                aluno.getCpf())).collect(Collectors.toList());
    }

}
