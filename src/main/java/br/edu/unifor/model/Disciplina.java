package br.edu.unifor.model;

import br.edu.unifor.dto.DisciplinaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Disciplina {

    public Disciplina() {

    }

    public Disciplina (String nome, Integer creditos){
        this.nome=nome;
        this.creditos = creditos;
    }

    public Disciplina (Long id,String nome, Integer creditos, Boolean ativo){
        this.id = id;
        this.nome=nome;
        this.creditos = creditos;
        this.ativo = ativo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "ativo")
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
