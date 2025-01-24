package br.edu.unifor.service;

import br.edu.unifor.dao.TurmaDAO;
import br.edu.unifor.dto.DisciplinaDTO;
import br.edu.unifor.dto.TurmaDTO;
import br.edu.unifor.model.Disciplina;
import br.edu.unifor.model.Turma;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TurmaService {

    private final TurmaDAO turmaDAO;

    /**
     * @param turmaDAO     *
     */
    @Inject
    public TurmaService(
            TurmaDAO turmaDAO) {
        this.turmaDAO = turmaDAO;
    }

    public List<TurmaDTO> getTurmas() {

        return turmaDAO.findAllTurmas().stream().map(turma -> new TurmaDTO(turma.getIdTurma(), turma.getDescricao()))
                .collect(Collectors.toList());
    }

    public TurmaDTO getTurmaById(Long matricula) {

        Turma turma = turmaDAO.findTurmaById(matricula);

        return new TurmaDTO(turma.getDescricao());
    }

    public void inserirTurma(TurmaDTO turmaDTO) {

        if (null == turmaDTO.getId()) {
            turmaDAO.inserirTurma(turmaDTO);
        }

    }

    public TurmaDTO atualizarTurma(Long id, TurmaDTO turmaDTO) {

        Turma turma;

        if (null != id) {
            turma = turmaDAO.atualizarTurma(id, turmaDTO);
            turmaDTO = new TurmaDTO(id, turma.getDescricao());
        }

        return turmaDTO;

    }

    public void excluirTurma(Long id) {

        if (null != id) {

            turmaDAO.excluirTurma(id);
        }

    }

}
