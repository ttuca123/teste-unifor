package br.edu.unifor.service;

import br.edu.unifor.dao.CursoDAO;
import br.edu.unifor.dto.CursoDTO;
import br.edu.unifor.model.Curso;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CursoService {

    private final CursoDAO cursoDAO;

    /**
     * @param cursoDAO     *
     */
    @Inject
    public CursoService(
            CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public List<CursoDTO> getCursos() {

        return cursoDAO.findAllCursos().stream().map(curso -> new CursoDTO(curso.getIdCurso(), curso.getNome(),
                curso.getDescricao())).collect(Collectors.toList());
    }

    public CursoDTO getCursoById(Long id) {

        Curso curso = cursoDAO.findCursoById(id);

        return new CursoDTO(curso.getIdCurso(), curso.getNome(),
                curso.getDescricao());
    }

    public void inserirCurso(CursoDTO cursoDTO) {

        if (null == cursoDTO.getId()) {

            cursoDAO.inserirCurso(cursoDTO);
        }

    }

    public CursoDTO atualizarCurso(Long matricula, CursoDTO cursoDTO) {

        Curso curso;

        if (null != matricula) {
            curso = cursoDAO.atualizarCurso(matricula, cursoDTO);
            cursoDTO = new CursoDTO(matricula, curso.getNome(), curso.getDescricao());
        }

        return cursoDTO;

    }

    public void excluirCurso(Long id) {

        if (null != id) {

            cursoDAO.excluirCurso(id);
        }

    }

}
