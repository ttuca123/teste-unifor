package br.edu.unifor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Artur Cavalcante
 * @since 22/01/2025
 */
public class ProfessorDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("fone")
    private String fone;

    @JsonProperty("ativo")
    private Boolean ativo;

    public ProfessorDTO() {

    }

    public ProfessorDTO(Long id, String nome, String cpf, String fone, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
        this.ativo = ativo;

    }

    public ProfessorDTO(String nome, String cpf, String fone, Boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
        this.ativo = ativo;
    }

    public ProfessorDTO(Long id, String nome, String cpf) {

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

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
