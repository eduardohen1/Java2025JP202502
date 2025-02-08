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

import br.com.ehmf.AppProdutos.model.Estoque;
import br.com.ehmf.AppProdutos.service.EstoqueService;

@RestController
@RequestMapping("/api/estoque") //http://localhost:8080/api/estoque
public class EstoqueResource {
	
	@Autowired
	private EstoqueService estoqueService;
	
	@PostMapping
	public ResponseEntity<Estoque> save(@RequestBody Estoque estoque){
		Estoque newEstoque = estoqueService.save(estoque);
		if(newEstoque == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(newEstoque);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Estoque>> findById(@PathVariable Long id){
		Optional<Estoque> findEstoque = estoqueService.findById(id);
		if(findEstoque == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(findEstoque); //200
	}
	
	@GetMapping
	public ResponseEntity<List<Estoque>> findAll(){
		List<Estoque> findEstoque = estoqueService.findAll();
		if(findEstoque == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(findEstoque); //200
	}
	
	@PutMapping
	public ResponseEntity<Estoque> update(@RequestBody Estoque estoque){
		Estoque updEstoque = estoqueService.update(estoque);
		if(updEstoque == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(updEstoque); //200
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		estoqueService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
	}
	
}
