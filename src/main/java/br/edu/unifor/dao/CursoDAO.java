package br.edu.unifor.dao;

import br.edu.unifor.dto.CursoDTO;
import br.edu.unifor.model.Curso;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CursoDAO implements PanacheRepository<Curso> {

    public List<Curso> findAllCursos() {

        PanacheQuery<Curso> cursos = findAll();

        return cursos.list();
    }


    public Curso findCursoById(Long id) {

        return findById(id);
    }

    @Transactional
    public void inserirCurso(CursoDTO cursoDTO) {

        Curso curso = new Curso(
                cursoDTO.getNome(),
                cursoDTO.getDescricao());

        persist(curso);

    }

    @Transactional
    public Curso atualizarCurso(Long id, CursoDTO cursoDTO) {

        Curso curso = findById(id);

        if (null != curso) {

            curso.setNome(cursoDTO.getNome());
            curso.setDescricao(cursoDTO.getDescricao());
            persist(curso);
        }
        return curso;
    }

    @Transactional
    public void excluirCurso(Long id) {

        Curso curso = findById(id);

        if (null != curso) {
            delete(curso);
        }
    }

}
