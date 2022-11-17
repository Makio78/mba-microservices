package br.com.fiap.mba.microservices.trilhas.controller;

import br.com.fiap.mba.microservices.trilhas.model.Trilhas;
import br.com.fiap.mba.microservices.trilhas.service.TrilhasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@RestController
@RequestMapping("/trilhas")
public class TrilhasController {

    private Logger logger = LoggerFactory.getLogger(TrilhasController.class);

    @Autowired
    private TrilhasService trilhasService;

    @GetMapping(value = "/")
    public List<Trilhas> getAllTrilhas() {
        logger.info("Getting all trilhas.");
        List<Trilhas> trilhas = trilhasService.findAll();

        for (Trilhas trilha: trilhas){
            if (trilha.getCursos() != null) {
                List<Object> cursos = new ArrayList<>();
                for (Object curso : trilha.getCursos()) {
                    String uri = "http://gateway:8080/cursos/" + curso;
                    RestTemplate restTemplate = new RestTemplate();
                    try {
                        ResponseEntity<Object> entity = restTemplate.getForEntity(uri, Object.class);
                        HttpStatus statusCode = entity.getStatusCode();
                        Map<Object, Object> response = (Map<Object, Object>) entity.getBody();
                        cursos.add(response);

                    } catch (HttpServerErrorException e) {
                        logger.info(e.toString());
                    }
                }
                trilha.setCursos(cursos);
            }

        }
        return trilhas;
    }


    @GetMapping(value = "/{trilhaId}")
    public Trilhas getTrilhaById(@PathVariable String trilhaId) {
        logger.info("Getting trilha with ID: {}", trilhaId);
        Trilhas trilha = trilhasService.findTrilhaById(trilhaId);

        if (trilha.getCursos() != null) {
            List<Object> cursos = new ArrayList<>();
            for (Object curso : trilha.getCursos()) {
                String uri = "http://gateway:8080/cursos/" + curso;
                RestTemplate restTemplate = new RestTemplate();
                try {
                    ResponseEntity<Object> entity = restTemplate.getForEntity(uri, Object.class);
                    HttpStatus statusCode = entity.getStatusCode();
                    Map<Object, Object> response = (Map<Object, Object>) entity.getBody();
                    cursos.add(response);

                } catch (HttpServerErrorException e) {
                    logger.info(e.toString());
                }
            }
            trilha.setCursos(cursos);
        }
    return trilha;

    }

    @GetMapping
    public List<Trilhas> getTrilhaByRegex(@RequestParam(value = "nome") String regexNome) {
            logger.info("Getting trilha with Nome: {}", regexNome);
            return trilhasService.findTrilhaByNomeRegex(regexNome);
    }

    @PostMapping(value = "/create")
    public Trilhas addTrilha(@RequestBody Trilhas trilhas) {
        logger.info("Saving trilha.");
        return trilhasService.saveOrUpdateTrilha(trilhas);
    }

    @PutMapping(value = "/update/{trilhaId}")
    public Trilhas updateTrilha(@PathVariable String trilhaId, @RequestBody Trilhas trilhas) {
        logger.info("Updating trilha with ID: {}", trilhaId);
        Trilhas trilha = trilhasService.findTrilhaById(trilhaId);

        if (trilha != null){

            if (trilhas.getId() != null){
                trilha.setId(trilhas.getId());
            }

            if (trilhas.getNome() != null){
                trilha.setNome(trilhas.getNome());
            }

            if (trilhas.getCursos() != null){
                trilha.setCursos(trilhas.getCursos());
            }
        }
        return trilha;
    }

    @DeleteMapping(value = "/delete/{trilhaId}")
    public void deleteTrilha(@PathVariable String trilhaId){
        logger.info("Deleting trilha with ID: {}", trilhaId);
        trilhasService.deleteTrilhaById(trilhaId);
    }
}
