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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunosResponse {

    private long id;
    private String nome;
    private String email;

    public AlunosResponse(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
