package br.com.fiap.mba.microservices.colaboradores.service;

import br.com.fiap.mba.microservices.colaboradores.dto.ColaboradorDTO;

import java.util.List;

public interface ColaboradorService {

    List<ColaboradorDTO> findAll();
    ColaboradorDTO findColaboradorById(String colaboradorId);
    List<ColaboradorDTO> findColaboradorByNomeRegex(String regexString);
    ColaboradorDTO saveOrUpdateColaborador(ColaboradorDTO colaboradorDTO);
    void deleteColaboradorById(String colaboradorId);
}
