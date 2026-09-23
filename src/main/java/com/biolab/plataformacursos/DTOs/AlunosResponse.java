package com.biolab.plataformacursos.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunosResponse {

    private long id;
    private String nome;
    private String email;
    private Set<CursosRequest> cursos;

    public AlunosResponse(String nome, String email, Set<CursosRequest> cursos) {
        this.nome = nome;
        this.email = email;
        this.cursos = cursos;
    }

    public AlunosResponse(long id, @NotBlank String nome, @NotBlank @Email String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
