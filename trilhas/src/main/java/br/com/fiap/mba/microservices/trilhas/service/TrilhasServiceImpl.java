package br.com.fiap.mba.microservices.trilhas.service;

import br.com.fiap.mba.microservices.trilhas.dto.TrilhasDTO;
import br.com.fiap.mba.microservices.trilhas.repository.TrilhasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhasServiceImpl implements TrilhasService {

    @Autowired
    private TrilhasRepository trilhasRepository;

    @Override
    public List<TrilhasDTO> findAll(){
        return trilhasRepository.findAll();
    }

    @Override
    public TrilhasDTO findTrilhaById(String trilhaId){
        return trilhasRepository.findTrilhaById(trilhaId);
    }

    @Override
    public List<TrilhasDTO> findTrilhaByNomeRegex(String regexString) {
        return trilhasRepository.findTrilhaByNomeRegex(regexString);
    }

    @Override
    public TrilhasDTO saveOrUpdateTrilha(TrilhasDTO trilhasDTO) {
        return trilhasRepository.save(trilhasDTO);
    }

    @Override
    public void deleteTrilhaById(String trilhaId) {
        trilhasRepository.deleteById(trilhaId);
    }
}
