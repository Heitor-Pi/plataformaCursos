package com.biolab.plataformacursos.services;

import com.biolab.plataformacursos.DTOs.AlunosRequest;
import com.biolab.plataformacursos.DTOs.AlunosResponse;
import com.biolab.plataformacursos.DTOs.CursosRequest;
import com.biolab.plataformacursos.DTOs.CursosResponse;
import com.biolab.plataformacursos.entities.Alunos;
import com.biolab.plataformacursos.entities.Cursos;
import com.biolab.plataformacursos.repositories.AlunosRepository;
import com.biolab.plataformacursos.repositories.CursosRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class CursosServices {
    private final CursosRepository cursosRepository;
    public CursosServices(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }

    public String criarCurso(CursosRequest request) {
        Cursos cursos = new Cursos();
        cursos.setTitulo(request.getTitulo());
        cursos.setCargaHoraria(request.getCargaHoraria());
        cursosRepository.save(cursos);
        return "Curso criado com sucesso!!";
    }

    public List<CursosResponse> mostrarCursos() {
        return cursosRepository.findAll().stream().map(
                cursos -> new CursosResponse(cursos.getId(),
                        cursos.getTitulo(), cursos.getCargaHoraria())).toList();
    }

    public CursosResponse buscarID(long id){
        Optional<Cursos> cursos = cursosRepository.findById(id);
        CursosResponse cursosResponse = new CursosResponse();
        cursosResponse.setTitulo(cursos.get().getTitulo());
        cursosResponse.setCargaHoraria(cursos.get().getCargaHoraria());
        cursosResponse.setId(cursos.get().getId());
        return cursosResponse;
    }

    public String deletarCursos(long id){
        Cursos cursos = cursosRepository.findById(id).orElseThrow();
        cursosRepository.deleteById(id);
        return "Curso excluído com sucesso";
    }

    public Cursos alterarDados(Long id, CursosRequest dadosAtualizados){
        Cursos cursosExistente = cursosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: "+id));
        cursosExistente.setTitulo(dadosAtualizados.getTitulo());
        cursosExistente.setCargaHoraria(dadosAtualizados.getCargaHoraria());
        return cursosRepository.save(cursosExistente);
    }




}
