package br.com.fiap.Colaboradores.service;

import br.com.fiap.Colaboradores.dto.ColaboradoresCreateUpdateDTO;
import br.com.fiap.Colaboradores.dto.ColaboradoresDTO;
import br.com.fiap.Colaboradores.entity.ColaboradoresEntity;
import br.com.fiap.Colaboradores.repository.ColaboradoresRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.sql.Timestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColaboradoresServiceImpl implements ColaboradoresService{

    private ColaboradoresRepository colaboradoresRepository;

    public ColaboradoresServiceImpl(ColaboradoresRepository colaboradoresRepository) {
        this.colaboradoresRepository = colaboradoresRepository;
    }

    @Override
    public List<ColaboradoresDTO> listAll(String nome) {
        List<ColaboradoresEntity> colaboradoresEntityList;
        if (nome == null) {
            colaboradoresEntityList = colaboradoresRepository.findAll();
        } else {
            colaboradoresEntityList = colaboradoresRepository.findByNome(nome);
        }
        return colaboradoresEntityList
                .stream()
                .map(entity -> new ColaboradoresDTO(entity))
                .collect(Collectors.toList());
    }


    @Override
    public ColaboradoresDTO findByMatricula(int matricula) {
        ColaboradoresEntity colaborador = colaboradoresRepository.findByMatricula(matricula);
        if (colaborador == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return new ColaboradoresDTO(colaborador);
        }
    }

    @Override
    public ColaboradoresDTO create(ColaboradoresCreateUpdateDTO colaboradoresCreateUpdateDTO) {
        ColaboradoresEntity colaborador = new ColaboradoresEntity();

        colaborador.setMatricula(colaboradoresCreateUpdateDTO.getMatricula());
        colaborador.setNome(colaboradoresCreateUpdateDTO.getNome());
        Date data = new Date();
        colaborador.setCreatedDate(new Timestamp(data.getTime()));
        colaborador.setModifiedDate(new Timestamp(data.getTime()));


        ColaboradoresEntity savedColaborador = colaboradoresRepository.save(colaborador);
        return new ColaboradoresDTO(savedColaborador);
    }

    @Override
    public ColaboradoresDTO update(int matricula, ColaboradoresCreateUpdateDTO alunosCreateUpdateDTO) {
        ColaboradoresEntity colaborador = colaboradoresRepository.findByMatricula(matricula);
        if (colaborador == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            colaborador.setNome(alunosCreateUpdateDTO.getNome());
            Date data = new Date();
            colaborador.setModifiedDate(new Timestamp(data.getTime()));

            ColaboradoresEntity savedColaborador = colaboradoresRepository.save(colaborador);
            return new ColaboradoresDTO(savedColaborador);
        }
    }

    @Override
    public void delete(int matricula) {
        ColaboradoresEntity colaboradores = colaboradoresRepository.findByMatricula(matricula);
        if (colaboradores == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            colaboradoresRepository.delete(colaboradores);
        }
    }
}
