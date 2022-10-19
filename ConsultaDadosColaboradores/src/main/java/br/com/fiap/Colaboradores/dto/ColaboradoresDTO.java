package br.com.fiap.Colaboradores.dto;

import br.com.fiap.Colaboradores.entity.ColaboradoresEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.util.Date;
import java.util.stream.Collectors;

public class ColaboradoresDTO {

    private int matricula;

    private String nome;


    public ColaboradoresDTO() {
    }

    public ColaboradoresDTO(int matricula, String nome, Date createdDate, Date modifiedDate) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public ColaboradoresDTO(ColaboradoresEntity entity) {
        this.matricula = entity.getMatricula();
        this.nome = entity.getNome();

    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
