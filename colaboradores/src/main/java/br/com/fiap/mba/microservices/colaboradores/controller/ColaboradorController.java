package br.com.fiap.mba.microservices.colaboradores.controller;

import br.com.fiap.mba.microservices.colaboradores.dto.ColaboradorDTO;
import br.com.fiap.mba.microservices.colaboradores.service.ColaboradorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    private Logger logger = LoggerFactory.getLogger(ColaboradorController.class);

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping(value = "/")
    public List<ColaboradorDTO> getAllColaboradores() {
        logger.info("Getting all colaboradores.");
        return colaboradorService.findAll();
    }

    @GetMapping(value = "/{colaboradorId}")
    public ColaboradorDTO getColaboradorById(@PathVariable String colaboradorId) {
        logger.info("Getting colaborador with ID: {}", colaboradorId);
        return colaboradorService.findColaboradorById(colaboradorId);
    }

    @GetMapping
    public List<ColaboradorDTO> getColaboradorByRegex(@RequestParam(value = "nome") String regexNome) {
            logger.info("Getting colaborador with Nome: {}", regexNome);
            return colaboradorService.findColaboradorByNomeRegex(regexNome);
    }

    @PostMapping(value = "/create")
    public ColaboradorDTO addColaborador(@RequestBody ColaboradorDTO colaboradorDTO) {
        logger.info("Saving colaborador.");
        return colaboradorService.saveOrUpdateColaborador(colaboradorDTO);
    }

    @PutMapping(value = "/update/{colaboradorId}")
    public ColaboradorDTO updateColaborador(@PathVariable String colaboradorId, @RequestBody ColaboradorDTO colaboradorDTO) {
        logger.info("Updating colaborador with ID: {}", colaboradorId);
        return colaboradorService.saveOrUpdateColaborador(colaboradorDTO);
    }

    @DeleteMapping(value = "/delete/{colaboradorId}")
    public void deleteColaborador(@PathVariable String colaboradorId){
        logger.info("Deleting colaborador with ID: {}", colaboradorId);
        colaboradorService.deleteColaboradorById(colaboradorId);
    }
}
