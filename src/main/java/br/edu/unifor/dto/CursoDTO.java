package br.edu.unifor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Artur Cavalcante
 * @since 22/01/2025
 */
public class CursoDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("descricao")
    private String descricao;

    public CursoDTO() {

    }

    public CursoDTO(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public CursoDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
