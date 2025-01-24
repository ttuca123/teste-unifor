package br.edu.unifor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Artur Cavalcante
 * @since 22/01/2025
 */
public class DisciplinaDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("creditos")
    private Integer creditos;

    @JsonProperty("ativo")
    private Boolean ativo;

    public DisciplinaDTO() {

    }

    public DisciplinaDTO(String nome, Integer creditos, Boolean ativo) {
        this.nome = nome;
        this.creditos = creditos;
        this.ativo = ativo;
    }

    public DisciplinaDTO(Long id, String nome, Integer creditos, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.creditos = creditos;
        this.ativo = ativo;
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
