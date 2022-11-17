package br.com.fiap.mba.microservices.cursos.controller;

import br.com.fiap.mba.microservices.cursos.model.Cursos;
import br.com.fiap.mba.microservices.cursos.service.CursosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    private Logger logger = LoggerFactory.getLogger(CursosController.class);

    @Autowired
    private CursosService cursosService;

    @GetMapping(value = "/")
    public List<Cursos> getAllCursos() {
        logger.info("Getting all cursos.");
        return cursosService.findAll();
    }

    @GetMapping(value = "/{cursoId}")
    public Cursos getCursoById(@PathVariable String cursoId) {
        logger.info("Getting curso with ID: {}", cursoId);
        return cursosService.findCursoById(cursoId);
    }

    @GetMapping
    public List<Cursos> getCursoByRegex(@RequestParam(value = "nome") String regexNome) {
        logger.info("Getting curso with Nome: {}", regexNome);
        return cursosService.findCursoByNomeRegex(regexNome);
    }

    @PostMapping(value = "/create")
    public Cursos addCurso(@RequestBody Cursos cursos) {
        logger.info("Saving curso.");
        return cursosService.saveOrUpdate(cursos);
    }

    @PutMapping(value = "/update/{cursoId}")
    public Cursos updateCurso(@PathVariable String cursoId, @RequestBody Cursos cursos) {
        logger.info("Updating curso with ID: {}", cursoId);
        Cursos curso = cursosService.findCursoById(cursoId);

        if (curso != null) {

            if (cursos.getId()!= null) {
                curso.setId(cursos.getId());
            }
            if (cursos.getNome() != null) {
                curso.setNome(cursos.getNome());
            }
            if (cursos.getCargaHoraria() != null) {
                curso.setCargaHoraria(cursos.getCargaHoraria());
            }
            if (cursos.getDescricao() != null) {
                curso.setDescricao(cursos.getDescricao());
            }

            cursosService.deleteCursoById(cursoId);
            cursosService.saveOrUpdate(curso);
        }

        return curso;
    }

    @DeleteMapping(value = "/delete/{cursoId}")
    public void deleteCurso(@PathVariable String cursoId){
        logger.info("Deleting curso with ID: {}", cursoId);
        cursosService.deleteCursoById(cursoId);
    }
}
