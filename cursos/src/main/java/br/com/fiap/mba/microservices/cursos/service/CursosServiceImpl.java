package br.com.fiap.mba.microservices.cursos.service;


import br.com.fiap.mba.microservices.cursos.model.Cursos;
import br.com.fiap.mba.microservices.cursos.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosServiceImpl implements CursosService {

    @Autowired
    private CursosRepository cursosRepository;

    @Override
    public List<Cursos> findAll(){
        return cursosRepository.findAll();
    }

    @Override
    public Cursos findCursoById(String cursoId){
        return cursosRepository.findCursoById(cursoId);
    }

    @Override
    public List<Cursos> findCursoByNomeRegex(String regexString) {
        return cursosRepository.findCursoByNomeRegex(regexString);
    }

    @Override
    public Cursos saveOrUpdateCurso(Cursos cursos) {
        return cursosRepository.save(cursos);
    }

    @Override
    public void deleteCursoById(String cursoId) {
        cursosRepository.deleteById(cursoId);
    }
}
