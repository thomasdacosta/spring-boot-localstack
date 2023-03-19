package br.com.thomasdacosta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CursoRequest {

    @JsonProperty("id_curso")
    private Integer idCurso;

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

}
