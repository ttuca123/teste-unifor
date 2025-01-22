package br.edu.unifor.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.unifor.dto.AlunoDTO;
import br.edu.unifor.model.Aluno;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AlunoDAO implements PanacheRepository<Aluno> {

    public List<Aluno> findAllAlunos() {

        List<Aluno> alunosLista = new ArrayList();

        PanacheQuery<Aluno> alunos = findAll();
        alunos.firstResultOptional().ifPresent(aluno -> alunosLista.add(aluno));

        return alunosLista;
    }

    @Transactional
    public void inserirAluno(AlunoDTO alunoDTO) {

        Aluno aluno = new Aluno(alunoDTO.getMatricula(),
                alunoDTO.getNome(),
                alunoDTO.getCpf(),
                new Date(),
                alunoDTO.getFone(),
                alunoDTO.getAtivo());

        persist(aluno);

    }

}
