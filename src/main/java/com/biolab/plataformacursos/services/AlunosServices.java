package com.biolab.plataformacursos.services;

import com.biolab.plataformacursos.DTOs.AlunosRequest;
import com.biolab.plataformacursos.DTOs.AlunosResponse;
import com.biolab.plataformacursos.entities.Alunos;
import com.biolab.plataformacursos.entities.Cursos;
import com.biolab.plataformacursos.repositories.AlunosRepository;
import com.biolab.plataformacursos.repositories.CursosRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class AlunosServices {
    private final AlunosRepository alunosRepository;
    private final CursosRepository cursosRepository;

    public AlunosServices(AlunosRepository alunosRepository, CursosRepository cursosRepository) {
        this.alunosRepository = alunosRepository;
        this.cursosRepository = cursosRepository;
    }

    public String criarAluno(AlunosRequest dto){
        Alunos alunos = new Alunos();
        alunos.setNome(dto.getNome());
        alunos.setEmail(dto.getEmail());
        alunosRepository.save(alunos);
        return "Usuario aluno criado com sucesso!!";
    }

    public List<AlunosResponse> mostrarAlunos(){
        return alunosRepository.findAll().stream().map(
    alunos -> new AlunosResponse(
            alunos.getId(), alunos.getNome(), alunos.getEmail())).toList();
    }

    public AlunosResponse buscarID(long id){
        Optional<Alunos> alunos = alunosRepository.findById(id);
        AlunosResponse alunosResponse = new AlunosResponse();
        alunosResponse.setNome(alunos.get().getNome());
        alunosResponse.setEmail(alunos.get().getEmail());
        alunosResponse.setId(alunos.get().getId());
        return alunosResponse;
    }

    public String deletarAlunos(long id){
        Alunos alunos = alunosRepository.findById(id).orElseThrow();
        alunosRepository.deleteById(id);
        return "Aluno excluída com sucesso";
    }

    public Alunos alterarDados(Long id, AlunosRequest dadosAtualizados){
        Alunos alunosExistente = alunosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: "+id));
        Cursos cursos = cursosRepository.getReferenceById(dadosAtualizados.getIdCursos());
        alunosExistente.setNome(dadosAtualizados.getNome());
        alunosExistente.setEmail(dadosAtualizados.getEmail());
        alunosExistente.setCursos(new HashSet<>());
        alunosExistente.getCursos().add(cursos);
        return alunosRepository.save(alunosExistente);
    }
}
