package br.com.fiap.mba.microservices.colaboradores.service;

import br.com.fiap.mba.microservices.colaboradores.dto.ColaboradorDTO;
import br.com.fiap.mba.microservices.colaboradores.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Override
    public List<ColaboradorDTO> findAll(){
        return colaboradorRepository.findAll();
    }

    @Override
    public ColaboradorDTO findColaboradorById(String colaboradorId){
        return colaboradorRepository.findCursoById(colaboradorId);
    }

    @Override
    public List<ColaboradorDTO> findColaboradorByNomeRegex(String regexString) {
        return colaboradorRepository.findColaboradorByNomeRegex(regexString);
    }

    @Override
    public ColaboradorDTO saveOrUpdateColaborador(ColaboradorDTO colaboradorDTO) {
        return colaboradorRepository.save(colaboradorDTO);
    }

    @Override
    public void deleteColaboradorById(String colaboradorId) {
        colaboradorRepository.deleteById(colaboradorId);
    }
}
