package br.com.fiap.Colaboradores.repository;

import br.com.fiap.Colaboradores.entity.ColaboradoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColaboradoresRepository extends JpaRepository<ColaboradoresEntity, Integer> {
    @Query(
            value = "SELECT * FROM colaboradores a WHERE a.nome LIKE ?1",
            nativeQuery = true)
    List<ColaboradoresEntity> findByNome(String nome);

    @Query(
            value = "SELECT * FROM colaboradores a WHERE a.matricula = ?1",
            nativeQuery = true)
    ColaboradoresEntity findByMatricula(int matricula);
}