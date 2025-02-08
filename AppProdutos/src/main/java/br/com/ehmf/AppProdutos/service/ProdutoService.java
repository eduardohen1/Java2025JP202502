package br.com.ehmf.AppProdutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehmf.AppProdutos.model.Produtos;
import br.com.ehmf.AppProdutos.repository.ProdutosRepository;

@Service
public class ProdutoService {

	@Autowired //injeção de dependência
	private ProdutosRepository produtoRepository;
	
	//CRUD - Create
	public Produtos save(Produtos produto) {
		//regra de negócio:
		//-Se o campo nome está preenchido
		if(produto.getNome() == null) {
			System.out.println("Nome do produto vazio.");
			return null;
		}
		//-Se o campo codigo de barras está preenchido
		if(produto.getCodigoBarras() == null) {
			System.out.println("Código de barras do produto vazio.");
			return null;
		}
		try {			
			//vai para o banco de dados 
			// 'INSERT INTO produto(nome,codigoBarras,valor) 
			// VALUES(produto.getNome(), produto.getCodigoBarras(),
			// produto.getValor());'
			return produtoRepository.save(produto);
		}catch (Exception e) {
			System.out.println("Erro ao inserir produto " + 
		                       produto.toString() + ": " + e.getMessage());
			return null;
		}
	}
	
	//CRUD - Read (leitura individual ou lista)
	public Optional<Produtos> findById(Long id){
		//select * from produto where id = ?id
		return produtoRepository.findById(id); 
	}
	
	public Optional<Produtos> findByCodigoBarras(String codigoBarras){
		if(codigoBarras== null) {
			System.out.println("Número do código de barras nulo.");
			return null;
		}else {
			//select * from produto where codigobarras = ?
			return produtoRepository.findByCodigoBarras(codigoBarras);
		}
	}
	
	public List<Produtos> findAll(){
		//select * from produto
		return produtoRepository.findAll();
	}
	
	//CRUD - Update
	public Produtos update(Produtos produto) {
		//Regra de negócio:
		// - Verificar se o produto existe; Se existir, atualizar, 
		//   caso não, insere novo.
		// ------------------------------------
		// - Pesquisar produto:
		Optional<Produtos> findProduto = produtoRepository.findById(produto.getId());
		
		//se o produto existir, atualizar:
		if(findProduto.isPresent()) {
			//crio um novo objeto de produtos e lanço os dados
			// do objeto que veio da Internet (parametro).
			Produtos updProduto = findProduto.get(); //setId
			updProduto.setNome(produto.getNome()); //veio por parametro
			updProduto.setCodigoBarras(produto.getCodigoBarras());
			updProduto.setPreco(produto.getPreco());
			return produtoRepository.save(updProduto); //UPDATE
		}
		return produtoRepository.save(produto); //INSERT		
	}
	
	//CRUD - Delete
	public void delete(Long id) {
		//delete from produto where id = ?id
		produtoRepository.deleteById(id);
	}
}
