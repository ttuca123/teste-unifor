package br.edu.unifor.model;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Cacheable
public class Usuario {

    public Usuario() {

    }

    public Usuario(Long id, String nome, String cpf, String fone, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
        this.ativo = ativo;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "fone")
    private String fone;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
