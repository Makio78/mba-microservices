package br.com.fiap.mba.microservices.trilhas.service;

import br.com.fiap.mba.microservices.trilhas.dto.TrilhasDTO;

import java.util.List;

public interface TrilhasService {

    List<TrilhasDTO> findAll();
    TrilhasDTO findTrilhaById(String trilhaId);
    List<TrilhasDTO> findTrilhaByNomeRegex(String regexString);
    TrilhasDTO saveOrUpdateTrilha(TrilhasDTO trilhasDTO);
    void deleteTrilhaById(String trilhaId);
}
