package br.edu.unifor.dao;

import br.edu.unifor.dto.ProfessorDTO;
import br.edu.unifor.model.Professor;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProfessorDAO implements PanacheRepository<Professor> {

    public List<Professor> findAllProfessors() {

        PanacheQuery<Professor> Professors = findAll();

        return Professors.list();
    }


    public Professor findProfessorById(Long id) {

        return findById(id);
    }

    @Transactional
    public void inserirProfessor(ProfessorDTO professorDTO) {

        Professor Professor = new Professor(
                professorDTO.getNome(),
                professorDTO.getCpf(),
                professorDTO.getFone(),
                true);

        persist(Professor);

    }

    @Transactional
    public Professor atualizarProfessor(Long matricula, ProfessorDTO ProfessorDTO) {

        Professor Professor = findById(matricula);

        if (null != Professor) {

            Professor.setNome(ProfessorDTO.getNome());
            Professor.setFone(ProfessorDTO.getFone());
            persist(Professor);
        }
        return Professor;
    }

    @Transactional
    public void excluirProfessor(Long id) {

        Professor Professor = findById(id);

        if (null != Professor) {
            delete(Professor);
        }
    }

}
