package br.com.fiap.mba.microservices.colaboradores.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "colaboradores")
public class Colaborador {

    @MongoId
    private String id;
    private String nome;
    private List<Object> trilhas;

    public Colaborador() {
    }

    public Colaborador(String id, String nome, List<Object> trilhas) {
        this.id = id;
        this.nome = nome;
        this.trilhas = trilhas;
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

    public List<Object> getTrilhas() {
        return trilhas;
    }

    public void setTrilhas(List<Object> trilhas) {
        this.trilhas = trilhas;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", trilhas=" + trilhas +
                '}';
    }
}
