package br.edu.unifor.service;

import br.edu.unifor.dao.DisciplinaDAO;
import br.edu.unifor.dto.DisciplinaDTO;
import br.edu.unifor.model.Disciplina;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DisciplinaService {

    private final DisciplinaDAO disciplinaDAO;

    /**
     * @param disciplinaDAO     *
     */
    @Inject
    public DisciplinaService(
            DisciplinaDAO disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
    }

    public List<DisciplinaDTO> getDisciplinas() {

        return disciplinaDAO.findAllDisciplinas().stream().map(disciplina -> new DisciplinaDTO(disciplina.getId(), disciplina.getNome(),
                disciplina.getCreditos(), disciplina.getAtivo())).collect(Collectors.toList());
    }

    public DisciplinaDTO getDisciplinaById(Long matricula) {

        Disciplina disciplina = disciplinaDAO.findDisciplinaById(matricula);

        return new DisciplinaDTO(disciplina.getId(), disciplina.getNome(),
                disciplina.getCreditos(), disciplina.getAtivo());
    }

    public void inserirDisciplina(DisciplinaDTO disciplinaDTO) {

        if (null == disciplinaDTO.getId()) {

            disciplinaDAO.inserirDisciplina(disciplinaDTO);
        }

    }

    public DisciplinaDTO atualizarDisciplina(Long matricula, DisciplinaDTO disciplinaDTO) {

        Disciplina disciplina;

        if (null != matricula) {
            disciplina = disciplinaDAO.atualizarDisciplina(matricula, disciplinaDTO);
            disciplinaDTO = new DisciplinaDTO(matricula, disciplina.getNome(), disciplina.getCreditos(), disciplina.getAtivo());
        }

        return disciplinaDTO;

    }

    public void excluirDisciplina(Long matricula) {

        if (null != matricula) {

            disciplinaDAO.excluirDisciplina(matricula);
        }

    }

}
