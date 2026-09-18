package com.biolab.plataformacursos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String cargaHoraria;

    @ManyToMany(mappedBy = "cursos")
    private Set<Alunos> alunos = new HashSet<>();

}
