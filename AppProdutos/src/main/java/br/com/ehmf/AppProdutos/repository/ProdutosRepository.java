package br.com.ehmf.AppProdutos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ehmf.AppProdutos.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	Optional<Produtos> findByCodigoBarras(String codigoBarras);

}
