package com.biolab.plataformacursos.DTOs;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursosResponse {
    private long id;

    private String titulo;

    private String cargaHoraria;

    public CursosResponse(String titulo, String cargaHoraria) {
        this.titulo = titulo;
        this.cargaHoraria = cargaHoraria;
    }
}
