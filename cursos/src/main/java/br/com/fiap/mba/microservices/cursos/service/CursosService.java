package br.com.fiap.mba.microservices.cursos.service;

import br.com.fiap.mba.microservices.cursos.model.Cursos;

import java.util.List;

public interface CursosService {

    List<Cursos> findAll();
    Cursos findCursoById(String cursoId);
    List<Cursos> findCursoByNomeRegex(String regexString);
    Cursos saveOrUpdate(Cursos cursos);
    void deleteCursoById(String cursoId);
}
