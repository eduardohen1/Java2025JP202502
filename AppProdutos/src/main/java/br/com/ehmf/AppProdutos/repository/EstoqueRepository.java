package br.com.ehmf.AppProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ehmf.AppProdutos.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
