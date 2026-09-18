package com.biolab.plataformacursos.repositories;

import com.biolab.plataformacursos.entities.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Alunos, Long> {
}
