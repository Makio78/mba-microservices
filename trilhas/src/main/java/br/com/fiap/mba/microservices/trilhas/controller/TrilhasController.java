package br.com.fiap.mba.microservices.trilhas.controller;

import br.com.fiap.mba.microservices.trilhas.dto.TrilhasDTO;
import br.com.fiap.mba.microservices.trilhas.service.TrilhasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/trilhas")
public class TrilhasController {

    private Logger logger = LoggerFactory.getLogger(TrilhasController.class);

    @Autowired
    private TrilhasService trilhasService;

    @GetMapping(value = "/")
    public List<TrilhasDTO> getAllTrilhas() {
        logger.info("Getting all trilhas.");
        return trilhasService.findAll();
    }

    @GetMapping(value = "/{trilhaId}")
    public TrilhasDTO getTrilhaById(@PathVariable String trilhaId) {
        logger.info("Getting trilha with ID: {}", trilhaId);
        return trilhasService.findTrilhaById(trilhaId);
    }

    @GetMapping
    public List<TrilhasDTO> getTrilhaByRegex(@RequestParam(value = "nome") String regexNome) {
            logger.info("Getting trilha with Nome: {}", regexNome);
            return trilhasService.findTrilhaByNomeRegex(regexNome);
    }

    @PostMapping(value = "/create")
    public TrilhasDTO addTrilha(@RequestBody TrilhasDTO trilhasDTO) {
        logger.info("Saving trilha.");
        return trilhasService.saveOrUpdateTrilha(trilhasDTO);
    }

    @PutMapping(value = "/update/{trilhaId}")
    public TrilhasDTO updateTrilha(@PathVariable String trilhaId, @RequestBody TrilhasDTO trilhasDTO) {
        logger.info("Updating trilha with ID: {}", trilhaId);
        return trilhasService.saveOrUpdateTrilha(trilhasDTO);
    }

    @DeleteMapping(value = "/delete/{trilhaId}")
    public void deleteTrilha(@PathVariable String trilhaId){
        logger.info("Deleting trilha with ID: {}", trilhaId);
        trilhasService.deleteTrilhaById(trilhaId);
    }
}
