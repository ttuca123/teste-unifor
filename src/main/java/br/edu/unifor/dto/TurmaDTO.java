package br.edu.unifor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Artur Cavalcante
 * @since 22/01/2025
 */
public class TurmaDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("descricao")
    private String descricao;

    public TurmaDTO() {

    }

    public TurmaDTO(String descricao) {
        this.descricao = descricao;
    }

    public TurmaDTO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
