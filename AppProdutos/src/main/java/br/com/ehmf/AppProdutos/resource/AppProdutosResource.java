package br.com.ehmf.AppProdutos.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //http://localhost:8080/api
public class AppProdutosResource {

	@GetMapping
	public String getApi() {
		return "API Java funcionando! 😎";
	}
	
	
	
}
