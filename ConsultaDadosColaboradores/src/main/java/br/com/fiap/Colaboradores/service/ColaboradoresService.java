package br.com.fiap.Colaboradores.service;

import br.com.fiap.Colaboradores.dto.ColaboradoresCreateUpdateDTO;
import br.com.fiap.Colaboradores.dto.ColaboradoresDTO;
import br.com.fiap.Colaboradores.entity.ColaboradoresEntity;

import java.util.List;

public interface ColaboradoresService {

    List<ColaboradoresDTO> listAll(String nome);
    ColaboradoresDTO findByMatricula(int matricula);
    ColaboradoresDTO create(ColaboradoresCreateUpdateDTO colaboradoresCreateUpdateDTO);
    ColaboradoresDTO update(int matricula, ColaboradoresCreateUpdateDTO colaboradoresCreateUpdateDTO);
    void delete(int id);
}
