package com.biolab.plataformacursos.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
    private Set<CursosRequest> cursos;

    public AlunosRequest(String nome, String email, long idCursos) {
        this.nome = nome;
        this.email = email;
        this.idCursos = idCursos;
    }
}
