package com.biolab.plataformacursos.controller;

import com.biolab.plataformacursos.DTOs.AlunosRequest;
import com.biolab.plataformacursos.DTOs.AlunosResponse;
import com.biolab.plataformacursos.DTOs.CursosRequest;
import com.biolab.plataformacursos.DTOs.CursosResponse;
import com.biolab.plataformacursos.entities.Alunos;
import com.biolab.plataformacursos.entities.Cursos;
import com.biolab.plataformacursos.services.CursosServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursosController {
    private final CursosServices services;

    public CursosController(CursosServices services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<?> criarCurso(@RequestBody CursosRequest req){
        return ResponseEntity.ok("Curso criado com sucesso!!" + services.criarCurso(req));
    }

    @GetMapping
    public ResponseEntity<List<CursosResponse>> mostrarCursos(){
        return ResponseEntity.ok(services.mostrarCursos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCursos(@PathVariable Long id) {
        services.deletarCursos(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cursos> alterarDados(@Valid @PathVariable Long id, @RequestBody CursosRequest dados){
        Cursos cursosAtualizados = services.alterarDados(id, dados);
        return ResponseEntity.ok(cursosAtualizados);
    }
}
