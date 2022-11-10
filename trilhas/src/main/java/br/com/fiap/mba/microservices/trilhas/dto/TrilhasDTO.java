package br.com.fiap.mba.microservices.trilhas.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trilhas")
public class TrilhasDTO {

    private String id;
    private String nome;


    public TrilhasDTO() {
    }

    public TrilhasDTO(String id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
