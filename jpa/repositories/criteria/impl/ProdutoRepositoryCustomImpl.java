package br.com.edusync.jpa.repositories.criteria.impl;

import br.com.edusync.jpa.Models.Produto;
import br.com.edusync.jpa.repositories.criteria.params.ProdutoFilterParam;
import br.com.edusync.jpa.repositories.criteria.ProdutoRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryCustomImpl implements ProdutoRepositoryCustom {

    private EntityManager entityManager;

    public ProdutoRepositoryCustomImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<Produto> getFiltro(ProdutoFilterParam param) {
        CriteriaBuilder criteriaBuilder= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);

        Root<Produto> produto = query.from(Produto.class);
        List<Predicate> predicates= new ArrayList<>();
        if (param.getDescricao()!=null){
            predicates.add(criteriaBuilder.like(produto.get("descricao"), "%" + param.getDescricao() + "%"));
        }
        if (param.getPrecoVenda()!=null){
            predicates.add(criteriaBuilder.equal(produto.get("saldoAtual"),"%" + param.getSaldoAtual()+"%"));
        }

        if (param.getPrecoVenda()!=null){
            predicates.add(criteriaBuilder.equal(produto.get("precoVenda"),"%" + param.getPrecoVenda()+"%"));
        }


        if (!predicates.isEmpty()){
            query.where(predicates.stream().toArray(Predicate[]::new));
        }

        TypedQuery<Produto> queryResult = this.entityManager.createQuery(query);

        return queryResult.getResultList();
    }




    @Override
    public List<Produto>positivo(Integer codigo){

        CriteriaBuilder criteriaBuilder =this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> produtoCriteriaQuery = criteriaBuilder.createQuery(Produto.class);

        Root<Produto>produto =produtoCriteriaQuery.from(Produto.class);

        if (codigo!= null){
            produtoCriteriaQuery.select(produto).where(criteriaBuilder.gt(produto.get("saldoAtual"), 0));
        }
        TypedQuery<Produto> produtoTypedQuery = this.entityManager.createQuery(produtoCriteriaQuery);
        return produtoTypedQuery.getResultList();
    }



}
