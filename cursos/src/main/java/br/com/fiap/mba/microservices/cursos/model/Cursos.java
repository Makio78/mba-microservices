package br.com.fiap.mba.microservices.cursos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cursos")
public class Cursos {

    @Id
    private String id;
    private String nome;
    private String cargaHoraria;
    private String descricao;

    public Cursos() {
    }

    public Cursos(String id, String nome, String cargaHoraria, String descricao) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Cursos{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cargaHoraria='" + cargaHoraria + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
