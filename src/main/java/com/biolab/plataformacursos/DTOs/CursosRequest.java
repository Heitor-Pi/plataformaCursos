package com.biolab.plataformacursos.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursosRequest {
    @NotBlank
    private String titulo;
    @NotBlank
    private String cargaHoraria;
}
