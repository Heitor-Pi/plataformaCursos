package com.biolab.plataformacursos.controller;

import com.biolab.plataformacursos.DTOs.AlunosRequest;
import com.biolab.plataformacursos.DTOs.AlunosResponse;
import com.biolab.plataformacursos.entities.Alunos;
import com.biolab.plataformacursos.services.AlunosServices;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunosController {
    private final AlunosServices services;

    public AlunosController(AlunosServices services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<?> criarAluno(@Valid @RequestBody AlunosRequest req){
        return ResponseEntity.ok(services.criarAluno(req));
    }

    @GetMapping
    public ResponseEntity<List<AlunosResponse>> mostrar(){
        return ResponseEntity.ok(services.mostrarAlunos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlunos(@PathVariable Long id){
        services.deletarAlunos(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alunos> alterarDados(@Valid @PathVariable Long id, @RequestBody AlunosRequest dados){
        Alunos alunosAtualizados = services.alterarDados(id, dados);
        return ResponseEntity.ok(alunosAtualizados);
    }
}
