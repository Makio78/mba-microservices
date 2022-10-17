package br.com.mba.colaborador.controller;

import br.com.mba.colaborador.dto.ColaboradorDto;
import br.com.mba.colaborador.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

@RestController
@RequestMapping("/Colaboradors")
public class ColaboradorController {

    @Autowired
    private ColaboradorService service;

    @GetMapping
    public Page<ColaboradorDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDto> detalhar(@PathVariable @NotNull Long id) {
        ColaboradorDto dto = service.obterPorId(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ColaboradorDto> cadastrar(@RequestBody @Valid ColaboradorDto dto, UriComponentsBuilder uriBuilder) {
        ColaboradorDto colaborador = service.criarColaborador(dto);
        URI endereco = uriBuilder.path("/Colaboradors/{id}").buildAndExpand(colaborador.getId()).toUri();

        return ResponseEntity.created(endereco).body(colaborador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColaboradorDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid ColaboradorDto dto) {
        ColaboradorDto atualizado = service.atualizarColaborador(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ColaboradorDto> remover(@PathVariable @NotNull Long id) {
        service.excluirColaborador(id);
        return ResponseEntity.noContent().build();
    }

}
