package br.com.fiap.mba.microservices.trilhas.service;

import br.com.fiap.mba.microservices.trilhas.model.Trilhas;

import java.util.List;

public interface TrilhasService {

    List<Trilhas> findAll();
    Trilhas findTrilhaById(String trilhaId);
    List<Trilhas> findTrilhaByNomeRegex(String regexString);
    Trilhas saveOrUpdateTrilha(Trilhas trilhas);
    void deleteTrilhaById(String trilhaId);
}
