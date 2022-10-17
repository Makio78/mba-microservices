package br.com.mba.colaborador.service;

import br.com.mba.colaborador.dto.ColaboradorDto;
import br.com.mba.colaborador.model.Colaborador;
import br.com.mba.colaborador.repository.ColaboradorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Retornar todos as colaboradores cadastradas no Banco de dados com paginação
     * @param paginacao
     * @return
     */
    public Page<ColaboradorDto> obterTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, ColaboradorDto.class));
    }

    /**
     * Retornar os colaboradores cadastradas no Banco de dados por id
     * @param id
     * @return
     */
    public ColaboradorDto obterPorId(Long id) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(colaborador, ColaboradorDto.class);
    }

    /**
     * Cadastrar os colaboradores no Banco de dados
     * @param dto
     * @return
     */
    public ColaboradorDto criarColaborador(ColaboradorDto dto) {
        Colaborador colaborador = modelMapper.map(dto, Colaborador.class);
        repository.save(colaborador);

        return modelMapper.map(colaborador, ColaboradorDto.class);
    }

    /**
     * Atualizar os colaboradores no Banco de dados
     * @param id
     * @param dto
     * @return
     */
    public ColaboradorDto atualizarColaborador(Long id, ColaboradorDto dto) {
        Colaborador colaborador = modelMapper.map(dto, Colaborador.class);
        colaborador.setId(id);
        colaborador = repository.save(colaborador);
        return modelMapper.map(colaborador, ColaboradorDto.class);
    }

    /**
     * Excluir o colaborador no Banco de dados
     * @param id
     */
    public void excluirColaborador(Long id) {
        repository.deleteById(id);
    }

}
