package br.com.fiap.mba.microservices.trilhas.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "trilhas")
public class Trilhas {

    @MongoId
    private String id;
    private String nome;
    private List<Object> cursos;

    public Trilhas() {
    }

    public Trilhas(String id, String nome, List<Object> cursos) {
        this.id = id;
        this.nome = nome;
        this.cursos = cursos;
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

    public List<Object>  getCursos() {
        return cursos;
    }

    public void setCursos(List<Object>  cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Trilhas{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
