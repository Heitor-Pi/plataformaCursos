package com.biolab.plataformacursos.repositories;

import com.biolab.plataformacursos.entities.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosRepository extends JpaRepository<Cursos, Long> {
}
