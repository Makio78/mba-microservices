package br.com.fiap.Colaboradores.dto;

public class ColaboradoresCreateUpdateDTO {

    private int matricula;

    private String nome;

    public ColaboradoresCreateUpdateDTO() {
    }

    public ColaboradoresCreateUpdateDTO(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
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
