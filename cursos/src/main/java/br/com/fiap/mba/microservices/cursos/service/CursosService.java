package br.com.fiap.mba.microservices.cursos.service;

import br.com.fiap.mba.microservices.cursos.model.Cursos;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CursosService {

    List<Cursos> findAll();
    Cursos findCursoById(String cursoId);
    List<Cursos> findCursoByNomeRegex(String regexString);
    Cursos saveOrUpdateCurso(Cursos cursos);
    void deleteCursoById(String cursoId);
}
