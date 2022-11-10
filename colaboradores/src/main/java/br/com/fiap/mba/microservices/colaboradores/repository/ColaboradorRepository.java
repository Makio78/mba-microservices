package br.com.fiap.mba.microservices.colaboradores.repository;

import br.com.fiap.mba.microservices.colaboradores.dto.ColaboradorDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ColaboradorRepository extends MongoRepository<ColaboradorDTO, String> {

    ColaboradorDTO findCursoById(String colaboradorId);
    //    @Query(("{$or : [{'nome': { $regex: ?0, $options:'i' }}, {'descricao': { $regex: ?0, $options:'i' }}]}"))
    @Query(("[{'nome': { $regex: ?0, $options:'i' }}]"))
    List<ColaboradorDTO> findColaboradorByNomeRegex(String regexString);
}
