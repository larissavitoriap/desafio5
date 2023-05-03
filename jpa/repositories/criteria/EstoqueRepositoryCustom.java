package br.com.edusync.jpa.repositories.criteria;

import br.com.edusync.jpa.Models.EstoqueMovimento;
import br.com.edusync.jpa.repositories.criteria.params.ProdutoFilterParam;

import java.util.List;

public interface EstoqueRepositoryCustom {
    List<EstoqueMovimento> getFiltro(ProdutoFilterParam param);
}
