package br.com.fiap.mba.microservices.trilhas.repository;

import br.com.fiap.mba.microservices.trilhas.model.Trilhas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrilhasRepository extends MongoRepository<Trilhas, String> {

    Trilhas findTrilhaById(String trilhaId);
    //    @Query(("{$or : [{'nome': { $regex: ?0, $options:'i' }}, {'descricao': { $regex: ?0, $options:'i' }}]}"))
    @Query(("[{'nome': { $regex: ?0, $options:'i' }}]"))
    List<Trilhas> findTrilhaByNomeRegex(String regexString);
}
