package br.com.mba.colaborador.repository;

import br.com.mba.colaborador.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

}
