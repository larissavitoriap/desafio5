package br.com.edusync.jpa.repositories.criteria;

import br.com.edusync.jpa.Models.Produto;
import br.com.edusync.jpa.repositories.criteria.params.ProdutoFilterParam;

import java.util.List;

public interface ProdutoRepositoryCustom {
    List<Produto> getFiltro (ProdutoFilterParam param);

    List<Produto>positivo(Integer codigo);
}








