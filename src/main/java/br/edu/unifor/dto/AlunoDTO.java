package br.edu.unifor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Artur Cavalcante
 * @since 22/01/2025
 */
public class AlunoDTO {

    @JsonProperty("matricula")
    private Long matricula;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("fone")
    private String fone;

    @JsonProperty("ativo")
    private Boolean ativo;

    public AlunoDTO() {

    }

    public AlunoDTO(String nome, String cpf, String fone, Boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
        this.ativo = ativo;
    }

    public AlunoDTO(Long matricula, String nome, String cpf) {

        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
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
