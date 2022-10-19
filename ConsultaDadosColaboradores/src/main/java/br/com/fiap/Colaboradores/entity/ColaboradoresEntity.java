package br.com.fiap.Colaboradores.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "colaboradores")
public class ColaboradoresEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int matricula;

    @Column
    private String nome;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Column(nullable = false, updatable = true)
    @LastModifiedDate
    private Date modifiedDate;

   /* public ColaboradoresEntity() {
    }

    public ColaboradoresEntity(int matricula, String nome, Date createdDate, Date modifiedDate) {
        this.matricula = matricula;
        this.nome = nome;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }*/

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
