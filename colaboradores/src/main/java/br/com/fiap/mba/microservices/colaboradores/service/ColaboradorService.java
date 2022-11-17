package br.com.fiap.mba.microservices.colaboradores.service;

import br.com.fiap.mba.microservices.colaboradores.model.Colaborador;

import java.util.List;

public interface ColaboradorService {

    List<Colaborador> findAll();
    Colaborador findColaboradorById(String colaboradorId);
    List<Colaborador> findColaboradorByNomeRegex(String regexString);
    Colaborador saveOrUpdateColaborador(Colaborador colaborador);
    void deleteColaboradorById(String colaboradorId);
}
