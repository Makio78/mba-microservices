package br.com.fiap.mba.microservices.colaboradores.repository;

import br.com.fiap.mba.microservices.colaboradores.model.Colaborador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ColaboradorRepository extends MongoRepository<Colaborador, String> {

    Colaborador findCursoById(String colaboradorId);
    //    @Query(("{$or : [{'nome': { $regex: ?0, $options:'i' }}, {'descricao': { $regex: ?0, $options:'i' }}]}"))
    @Query(("[{'nome': { $regex: ?0, $options:'i' }}]"))
    List<Colaborador> findColaboradorByNomeRegex(String regexString);
}
