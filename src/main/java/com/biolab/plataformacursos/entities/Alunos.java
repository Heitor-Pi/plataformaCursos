package com.biolab.plataformacursos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotBlank @Email
    @Column(length = 150)
    private String email;

    @ManyToMany
    @JoinTable(name = "matricula",
    joinColumns = @JoinColumn(name="alunos_id"),
    inverseJoinColumns = @JoinColumn(name="cursos_id"))
    private Set<Cursos> cursos =new HashSet<>();
}
