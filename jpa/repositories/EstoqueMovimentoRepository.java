package br.com.edusync.jpa.repositories;

import br.com.edusync.jpa.Models.EstoqueMovimento;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface EstoqueMovimentoRepository extends JpaRepository<EstoqueMovimento, Integer> {
}
