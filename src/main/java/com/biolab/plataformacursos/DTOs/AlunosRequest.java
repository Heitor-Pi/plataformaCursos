package com.biolab.plataformacursos.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunosRequest {
    @NotBlank
    private String nome;
    @NotBlank @Email
    @Column(length = 150)
    private String email;
    private long idCursos;
}
