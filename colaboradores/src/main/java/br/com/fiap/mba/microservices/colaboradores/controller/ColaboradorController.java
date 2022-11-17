package br.com.fiap.mba.microservices.colaboradores.controller;

import br.com.fiap.mba.microservices.colaboradores.model.Colaborador;
import br.com.fiap.mba.microservices.colaboradores.service.ColaboradorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    private Logger logger = LoggerFactory.getLogger(ColaboradorController.class);

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping(value = "/")
    public List<Colaborador> getAllColaboradores() {
        logger.info("Getting all colaboradores.");
        List<Colaborador> colaboradores = colaboradorService.findAll();

        for (Colaborador colaborador: colaboradores){
            if (colaborador.getTrilhas() != null) {
                List<Object> trilhas = new ArrayList<>();
                for (Object trilha : colaborador.getTrilhas()) {
                    String uri = "http://gateway:8080/trilhas/" + trilha;
                    RestTemplate restTemplate = new RestTemplate();
                    try {
                        ResponseEntity<Object> entity = restTemplate.getForEntity(uri, Object.class);
                        HttpStatus statusCode = entity.getStatusCode();
                        Map<Object, Object> response = (Map<Object, Object>) entity.getBody();
                        trilhas.add(response);

                    } catch (HttpServerErrorException e) {
                        logger.info(e.toString());
                    }
                }
                colaborador.setTrilhas(trilhas);
            }

        }
        return colaboradores;
    }

    @GetMapping(value = "/{colaboradorId}")
    public Colaborador getColaboradorById(@PathVariable String colaboradorId) {
        logger.info("Getting colaborador with ID: {}", colaboradorId);
        Colaborador colaborador = colaboradorService.findColaboradorById(colaboradorId);

        if (colaborador.getTrilhas() != null) {
            List<Object> trilhas = new ArrayList<>();
            for (Object trilha : colaborador.getTrilhas()) {
                String uri = "http://gateway:8080/trilhas/" + trilha;
                RestTemplate restTemplate = new RestTemplate();
                try {
                    ResponseEntity<Object> entity = restTemplate.getForEntity(uri, Object.class);
                    HttpStatus statusCode = entity.getStatusCode();
                    Map<Object, Object> response = (Map<Object, Object>) entity.getBody();
                    trilhas.add(response);

                } catch (HttpServerErrorException e) {
                    logger.info(e.toString());
                }
            }
            colaborador.setTrilhas(trilhas);
        }

        return colaborador;
    }

    @GetMapping
    public List<Colaborador> getColaboradorByRegex(@RequestParam(value = "nome") String regexNome) {
            logger.info("Getting colaborador with Nome: {}", regexNome);
            return colaboradorService.findColaboradorByNomeRegex(regexNome);
    }

    @PostMapping(value = "/create")
    public Colaborador addColaborador(@RequestBody Colaborador colaborador) {
        logger.info("Saving colaborador.");
        return colaboradorService.saveOrUpdateColaborador(colaborador);
    }

    @PutMapping(value = "/update/{colaboradorId}")
    public Colaborador updateColaborador(@PathVariable String colaboradorId, @RequestBody Colaborador colaborador) {
        logger.info("Updating colaborador with ID: {}", colaboradorId);
        return colaboradorService.saveOrUpdateColaborador(colaborador);
    }

    @DeleteMapping(value = "/delete/{colaboradorId}")
    public void deleteColaborador(@PathVariable String colaboradorId){
        logger.info("Deleting colaborador with ID: {}", colaboradorId);
        colaboradorService.deleteColaboradorById(colaboradorId);
    }
}
