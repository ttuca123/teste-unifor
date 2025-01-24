package br.edu.unifor.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.edu.unifor.dao.AlunoDAO;
import br.edu.unifor.dto.AlunoDTO;
import br.edu.unifor.model.Aluno;
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

        return alunoDAO.findAllAlunos().stream().map(aluno -> new AlunoDTO(aluno.getMatricula(), aluno.getNome(),
                aluno.getCpf(), aluno.getFone(), aluno.getAtivo())).collect(Collectors.toList());
    }


    public AlunoDTO getAlunoByMatricula(Long matricula) {

        Aluno aluno = alunoDAO.findAlunoById(matricula);

        return new AlunoDTO(aluno.getMatricula(), aluno.getNome(),
                aluno.getCpf(), aluno.getFone(), aluno.getAtivo());
    }




    public void inserirAluno(AlunoDTO alunoDTO) {

        if (null == alunoDTO.getMatricula()) {

            alunoDAO.inserirAluno(alunoDTO);
        }

    }

    public AlunoDTO atualizarAluno(Long matricula, AlunoDTO alunoDTO) {

        Aluno aluno;

        if (null != matricula) {

            aluno = alunoDAO.atualizarAluno(matricula, alunoDTO);
            alunoDTO = new AlunoDTO(matricula, aluno.getNome(), aluno.getCpf(), aluno.getFone(), aluno.getAtivo());
        }

        return alunoDTO;

    }

    public void excluirAluno(Long matricula) {

        if (null != matricula) {

            alunoDAO.excluirAluno(matricula);
        }

    }

}
