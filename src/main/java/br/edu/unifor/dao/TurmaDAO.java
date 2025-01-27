package br.edu.unifor.dao;

import br.edu.unifor.dto.TurmaDTO;
import br.edu.unifor.model.Turma;
import br.edu.unifor.model.Turma;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TurmaDAO implements PanacheRepository<Turma> {

    public List<Turma> findAllTurmas() {

        PanacheQuery<Turma> turmas = findAll();

        return turmas.list();
    }


    public Turma findTurmaById(Long id) {

        return findById(id);
    }

    @Transactional
    public void inserirTurma(TurmaDTO TurmaDTO) {

        Turma Turma = new Turma(TurmaDTO.getDescricao());
        persist(Turma);

    }

    @Transactional
    public Turma atualizarTurma(Long matricula, TurmaDTO TurmaDTO) {

        Turma turma = findById(matricula);

        if (null != turma) {
            turma.setDescricao(TurmaDTO.getDescricao());
            persist(turma);
        }
        return turma;
    }

    @Transactional
    public void excluirTurma(Long id) {

        Turma turma = findById(id);

        if (null != turma) {
            delete(turma);
        }
    }

}
