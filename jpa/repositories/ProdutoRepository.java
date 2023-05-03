package br.com.edusync.jpa.repositories;

import br.com.edusync.jpa.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
public List <Produto> findByDescricaoContainingIgnoreCase(String descricao);


}
