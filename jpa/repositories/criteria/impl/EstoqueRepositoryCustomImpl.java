package br.com.edusync.jpa.repositories.criteria.impl;

import br.com.edusync.jpa.Models.EstoqueMovimento;
import br.com.edusync.jpa.repositories.EstoqueMovimentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public abstract class EstoqueRepositoryCustomImpl implements EstoqueMovimentoRepository {


    private EntityManager entityManager;
    public void EstoqueRepsitoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<EstoqueMovimento> listarHistoricoDeMovimento(Integer produtoId){
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<EstoqueMovimento> estoqueMovimentoCriteriaQuery = criteriaBuilder.createQuery(EstoqueMovimento.class);

        Root<EstoqueMovimento> produtoRoot = estoqueMovimentoCriteriaQuery.from(EstoqueMovimento.class);

        estoqueMovimentoCriteriaQuery.select(produtoRoot).where(criteriaBuilder.equal(produtoRoot.get("produto"), produtoId));

        TypedQuery<EstoqueMovimento> estoqueMovimentoTypedQuery = this.entityManager.createQuery((estoqueMovimentoCriteriaQuery));

        return estoqueMovimentoTypedQuery.getResultList();

    }



}
