package br.com.edusync.jpa.repositories;

import br.com.edusync.jpa.Models.FuncionarioResponsavel;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FuncionarioResponsavelRepository extends JpaRepository<FuncionarioResponsavel, Integer> {
}
