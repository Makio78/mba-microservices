package br.com.fiap.mba.microservices.trilhas.service;

import br.com.fiap.mba.microservices.trilhas.model.Trilhas;
import br.com.fiap.mba.microservices.trilhas.repository.TrilhasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhasServiceImpl implements TrilhasService {

    @Autowired
    private TrilhasRepository trilhasRepository;

    @Override
    public List<Trilhas> findAll(){
        return trilhasRepository.findAll();
    }

    @Override
    public Trilhas findTrilhaById(String trilhaId){
        return trilhasRepository.findTrilhaById(trilhaId);
    }

    @Override
    public List<Trilhas> findTrilhaByNomeRegex(String regexString) {
        return trilhasRepository.findTrilhaByNomeRegex(regexString);
    }

    @Override
    public Trilhas saveOrUpdateTrilha(Trilhas trilhas) {
        return trilhasRepository.save(trilhas);
    }

    @Override
    public void deleteTrilhaById(String trilhaId) {
        trilhasRepository.deleteById(trilhaId);
    }
}
