package br.com.ehmf.AppProdutos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ehmf.AppProdutos.model.Produtos;
import br.com.ehmf.AppProdutos.service.ProdutoService;

//API RESTFull - trata o retorno com Json... API REST - trata objeto o retorno

@RestController
@RequestMapping("/api/produtos") //http://localhost:8080/api/produtos
public class ProdutoResource {
	
	@Autowired
	ProdutoService produtoService;
	
	@PostMapping //POST http://localhost:8080/api/produtos
	public ResponseEntity<Produtos> save(@RequestBody Produtos produto) {
		Produtos newProduto = produtoService.save(produto);
		if(newProduto == null) {
			return ResponseEntity.badRequest().build(); //dê status code 400
		}else {
			return ResponseEntity.ok(newProduto); //dê status code 200 e retorna objeto
		}
	}
	
	@GetMapping("/{id}") //GET http://localhost:8080/api/produtos/6
	public ResponseEntity<Optional<Produtos>> findById(@PathVariable Long id){
		Optional<Produtos> produto = produtoService.findById(id);
		if(produto.isEmpty()) { //isEmpty quer dizer que está vazio no Optional
			return ResponseEntity.notFound().build(); //404
		}else {
			return ResponseEntity.ok(produto); //200
		}
	}
	
	@GetMapping("/codBarras/{codigoBarras}") //GET http://localhost:8080/api/produtos/codBarras/646464654654646
	public ResponseEntity<Optional<Produtos>> findByCodigoBarras(
			@PathVariable String codigoBarras){
		Optional<Produtos> produto = produtoService.findByCodigoBarras(codigoBarras);
		if(produto.isEmpty()) { //isEmpty quer dizer que está vazio no Optional
			return ResponseEntity.notFound().build(); //404
		}else {
			return ResponseEntity.ok(produto); //200
		}
	}
	
	@GetMapping //GET http://localhost:8080/api/produtos
	public ResponseEntity<List<Produtos>> findAll(){
		List<Produtos> produtos = produtoService.findAll();
		if(produtos == null)
			return ResponseEntity.badRequest().build();
		if(produtos.size() == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(produtos);
	}
	
	@PutMapping //PUT http://localhost:8080/api/produtos
	public ResponseEntity<Produtos> update(@RequestBody Produtos produto){
		Produtos updProduto = produtoService.update(produto);
		if(updProduto == null) {
			return ResponseEntity.badRequest().build(); //dê status code 400
		}else {
			return ResponseEntity.ok(updProduto); //dê status code 200 e retorna objeto
		}
	}
	
	@DeleteMapping("/{id}") //DELETE http://localhost:8080/api/produtos/1
	public ResponseEntity<?> delete(@PathVariable Long id){
		produtoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
	}
	
}
