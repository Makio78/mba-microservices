package br.com.fiap.Colaboradores.controller;

import br.com.fiap.Colaboradores.dto.ColaboradoresCreateUpdateDTO;
import br.com.fiap.Colaboradores.dto.ColaboradoresDTO;
import br.com.fiap.Colaboradores.service.ColaboradoresService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("colaboradores")
public class ColaboradoresController {
    private ColaboradoresService ColaboradoresService;

    public ColaboradoresController(ColaboradoresService ColaboradoresService) {
        this.ColaboradoresService = ColaboradoresService;
    }

    @GetMapping
    public List<ColaboradoresDTO> listColaboradores(
            @RequestParam(required = false) String nome) {
        return ColaboradoresService.listAll(nome);
    }

    @GetMapping("{matricula}")
    public ColaboradoresDTO getByMatricula(@PathVariable int matricula) {
        return ColaboradoresService.findByMatricula(matricula);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ColaboradoresDTO insert(
            @RequestBody ColaboradoresCreateUpdateDTO createUpdateColaboradoresDTO) {
        return ColaboradoresService.create(createUpdateColaboradoresDTO);
    }

    @PutMapping("{matricula}")
    public ColaboradoresDTO update(
            @RequestBody ColaboradoresCreateUpdateDTO createUpdateColaboradoresDTO,
            @PathVariable int matricula) {
        return ColaboradoresService.update(matricula, createUpdateColaboradoresDTO);
    }

    @DeleteMapping("{matricula}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int matricula) {
        ColaboradoresService.delete(matricula);
    }

}
