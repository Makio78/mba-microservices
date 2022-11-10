package br.com.fiap.mba.microservices.cursos.controller;

import br.com.fiap.mba.microservices.cursos.model.Cursos;
import br.com.fiap.mba.microservices.cursos.service.CursosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return cursosService.saveOrUpdateCurso(cursos);
    }

    @PutMapping(value = "/update/{cursoId}")
    public Cursos updateCurso(@PathVariable String cursoId, @RequestBody Cursos cursos) {
        logger.info("Updating curso with ID: {}", cursoId);
        return cursosService.saveOrUpdateCurso(cursos);
    }

    @DeleteMapping(value = "/delete/{cursoId}")
    public void deleteCurso(@PathVariable String cursoId){
        logger.info("Deleting curso with ID: {}", cursoId);
        cursosService.deleteCursoById(cursoId);
    }
}
