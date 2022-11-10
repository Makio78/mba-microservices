package br.com.fiap.mba.microservices.colaboradores.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "colaboradores")
public class ColaboradorDTO {

    private String id;
    private String nome;

    public ColaboradorDTO() {
    }

    public ColaboradorDTO(String id, String nome) {
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
