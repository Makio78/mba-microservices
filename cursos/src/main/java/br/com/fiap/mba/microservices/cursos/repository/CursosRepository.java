package br.com.fiap.mba.microservices.cursos.repository;

import br.com.fiap.mba.microservices.cursos.model.Cursos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

public interface CursosRepository extends MongoRepository<Cursos, String> {

    Cursos findCursoById(String cursoId);
    //    @Query(("{$or : [{'nome': { $regex: ?0, $options:'i' }}, {'descricao': { $regex: ?0, $options:'i' }}]}"))
    @Query(("[{'nome': { $regex: ?0, $options:'i' }}]"))
    List<Cursos> findCursoByNomeRegex(String regexString);
}
