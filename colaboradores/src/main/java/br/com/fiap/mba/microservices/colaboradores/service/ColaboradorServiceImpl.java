package br.com.fiap.mba.microservices.colaboradores.service;

import br.com.fiap.mba.microservices.colaboradores.model.Colaborador;
import br.com.fiap.mba.microservices.colaboradores.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Override
    public List<Colaborador> findAll(){
        return colaboradorRepository.findAll();
    }

    @Override
    public Colaborador findColaboradorById(String colaboradorId){
        return colaboradorRepository.findCursoById(colaboradorId);
    }

    @Override
    public List<Colaborador> findColaboradorByNomeRegex(String regexString) {
        return colaboradorRepository.findColaboradorByNomeRegex(regexString);
    }

    @Override
    public Colaborador saveOrUpdateColaborador(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public void deleteColaboradorById(String colaboradorId) {
        colaboradorRepository.deleteById(colaboradorId);
    }
}
