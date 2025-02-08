package br.com.ehmf.AppProdutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehmf.AppProdutos.model.Estoque;
import br.com.ehmf.AppProdutos.model.Produtos;
import br.com.ehmf.AppProdutos.repository.EstoqueRepository;
import br.com.ehmf.AppProdutos.repository.ProdutosRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private ProdutosRepository produtoRepository;
	
	public Estoque save(Estoque estoque) {		
		//verificar se o produto existe, caso não avisar:
		if(estoque.getProduto().getId() != null) {
			//buscar o produto no BD:
			Optional<Produtos> findProduto = produtoRepository
					.findById(estoque.getProduto().getId());
			if(findProduto.isEmpty()) {
				System.out.println("Produto não encontrado");
				return null;
			}else {
				estoque.setProduto(findProduto.get());
				return estoqueRepository.save(estoque);
			}			
		}else {
			System.out.println("Produto nulo");
			return null;
		}		
	}
	
	public Optional<Estoque> findById(Long id){
		return estoqueRepository.findById(id);
	}
	
	public List<Estoque> findAll(){
		return estoqueRepository.findAll();
	}
	
	public Estoque update(Estoque estoque) {
		//Pesquisar se o estoque existe
		Optional<Estoque> findEstoque = estoqueRepository
				.findById(estoque.getId());
		//se existir, atualizar:
		if(findEstoque.isPresent()) {
			//variavel auxiliar
			Estoque updEstoque = findEstoque.get();
			updEstoque.setQuantidade(estoque.getQuantidade());
			//gravar no banco
			return estoqueRepository.save(updEstoque);
		}
		return estoqueRepository.save(estoque);
	}
	
	public void delete(Long id) {
		estoqueRepository.deleteById(id);
	}
	
}
