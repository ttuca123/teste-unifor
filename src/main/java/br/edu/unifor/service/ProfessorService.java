package br.edu.unifor.service;

import br.edu.unifor.dao.ProfessorDAO;
import br.edu.unifor.dto.AlunoDTO;
import br.edu.unifor.dto.ProfessorDTO;
import br.edu.unifor.model.Aluno;
import br.edu.unifor.model.Professor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProfessorService {

    private final ProfessorDAO professorDAO;

    /**
     * @param ProfessorDAO     *
     */
    @Inject
    public ProfessorService(
            ProfessorDAO ProfessorDAO) {
        this.professorDAO = ProfessorDAO;
    }

    public List<ProfessorDTO> getProfessores() {

        return professorDAO.findAllProfessors().stream().map(professor -> new ProfessorDTO(professor.getId(), professor.getNome(),
                professor.getCpf(), professor.getFone(), professor.getAtivo())).collect(Collectors.toList());
    }

    public ProfessorDTO getProfessorById(Long matricula) {

        Professor professor = professorDAO.findProfessorById(matricula);

        return new ProfessorDTO(professor.getId(), professor.getNome(),
                professor.getCpf(), professor.getFone(), professor.getAtivo());
    }




    public void inserirProfessor(ProfessorDTO professorDTO) {

        if (null == professorDTO.getId()) {

            professorDAO.inserirProfessor(professorDTO);
        }

    }

    public ProfessorDTO atualizarProfessor(Long matricula, ProfessorDTO professorDTO) {

        Professor professor;

        if (null != matricula) {
            professor = professorDAO.atualizarProfessor(matricula, professorDTO);
            professorDTO = new ProfessorDTO(matricula, professor.getNome(), professor.getCpf(), professor.getFone(), professor.getAtivo());
        }

        return professorDTO;

    }

    public void excluirProfessor(Long matricula) {

        if (null != matricula) {

            professorDAO.excluirProfessor(matricula);
        }

    }

}
