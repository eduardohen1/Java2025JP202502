package br.com.ehmf.AppProdutos.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ehmf.AppProdutos.model.Produtos;

@RestController
@RequestMapping("/api") //http://localhost:8080/api
public class AppProdutosResource {

	@GetMapping //http://localhost:8080/api
	public String getApi() {
		return "API Java funcionando! 😎";
	}
	
	@GetMapping("getProduto") //http://localhost:8080/api/getProduto
	public Produtos getProduto() {
		Produtos produto = new Produtos();
		produto.setCodigoBarras("665465465465464");
		produto.setNome("Monito Dell 29p");
		produto.setPreco(1000.0);
		
		System.out.println(produto);
		
		return produto;
	}
	
	@GetMapping("getProdutos") //http://localhost:8080/api/getProdutos
	public List<Produtos> getProdutos(){
		List<Produtos> listProdutos = new ArrayList<Produtos>();
		
		Produtos produto1 = new Produtos();
		produto1.setCodigoBarras("665465465465464");
		produto1.setNome("Monito Dell 29p");
		produto1.setPreco(1000.0);		
		listProdutos.add(produto1);
		
		Produtos produto2 = new Produtos();
		produto2.setCodigoBarras("6564987987");
		produto2.setNome("HD 1tb Samsung SSD");
		produto2.setPreco(800.0);		
		listProdutos.add(produto2);
		
		Produtos produto3 = new Produtos();
		produto3.setCodigoBarras("656498798654adfadf67987");
		produto3.setNome("Mouse Longtech");
		produto3.setPreco(150.0);		
		listProdutos.add(produto3);
		
		return listProdutos;
	}
	
	
}
