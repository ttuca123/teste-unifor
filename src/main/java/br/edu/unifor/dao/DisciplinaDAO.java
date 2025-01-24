package br.edu.unifor.dao;

import br.edu.unifor.dto.DisciplinaDTO;
import br.edu.unifor.model.Disciplina;
import br.edu.unifor.model.Disciplina;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DisciplinaDAO implements PanacheRepository<Disciplina> {

    public List<Disciplina> findAllDisciplinas() {

        PanacheQuery<Disciplina> disciplinas = findAll();

        return disciplinas.list();
    }


    public Disciplina findDisciplinaById(Long id) {

        return findById(id);
    }

    @Transactional
    public void inserirDisciplina(DisciplinaDTO disciplinaDTO) {

        Disciplina Disciplina = new Disciplina(
                disciplinaDTO.getId(),
                disciplinaDTO.getNome(),
                disciplinaDTO.getCreditos(),
                true);

        persist(Disciplina);

    }

    @Transactional
    public Disciplina atualizarDisciplina(Long matricula, DisciplinaDTO disciplinaDTO) {

        Disciplina disciplina = findById(matricula);

        if (null != disciplina) {

            disciplina.setNome(disciplinaDTO.getNome());
            disciplina.setCreditos(disciplinaDTO.getCreditos());
            persist(disciplina);
        }
        return disciplina;
    }

    @Transactional
    public void excluirDisciplina(Long id) {

        Disciplina disciplina = findById(id);

        if (null != disciplina) {
            delete(disciplina);
        }
    }

}
