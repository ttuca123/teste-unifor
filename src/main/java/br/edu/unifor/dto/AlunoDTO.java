package br.edu.unifor.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Artur Cavalcante
 * @since 22/01/2025
 */
public class AlunoDTO implements Serializable {

    @JsonProperty("matricula")
    private Long matricula;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cpf")
    private String cpf;

    public AlunoDTO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
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

}
