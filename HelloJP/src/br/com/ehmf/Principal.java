package br.com.ehmf;

public class Principal {

	public static void main(String[] args) {
		System.out.println(">>> Hello JP!!!");
		System.out.println("------------------------");
		System.out.println(":: OPERADORES LOGICOS ::");
		
		//validacao por operador lógico
		boolean condicao = true;
		if(condicao == true) {
			System.out.println("* Minha condicao e Verdadeira!");
		}else {
			System.out.println("* Minha condicao e Falsa!");
		}
		condicao = false;
		if(!condicao) {
			System.out.println("Variavel ainda false");
		}
		int idade = 15;
		if(idade < 15) 
			System.out.println("Ainda não teve festa");
		else 
			System.out.println("Vou ter que gastar com festa!");
		
		idade = 0;
		switch(idade) {
			case 2:
				System.out.println("Ainda esta de fralda");
				break;
			case 15:
				System.out.println("Vamos ter festa");
				break;
			case 16:
				System.out.println("Posso votar nas eleicoes");
				break;
			case 18:
			case 19:
			case 20:
				System.out.println("Posso tirar habilitacao");
				break;
			default:
				if(idade > 0) {
					System.out.println("Aqui pode qualquer valor que nao esteja escrito");
				}
				break;
		}
		
		//looping
		int max = 21;
		for(int numero = 0; numero <= max; numero++) {
			//System.out.println("> " + numero);
			//colocar * na frente do número se ele é par
			if(numero % 2 == 0) {
				System.out.println("> " + numero + " *");
			}else {
				System.out.println("> " + numero);
			}
		}
		
		int indice = 0;
		while(indice <= 100) {
			System.out.print("Escrevendo indice = " + indice);			
			switch(indice) {
				case 45:
					System.out.println("- Achei o número 😁!!!");
					break;
				default:
					System.out.println(" - Não achei 😢");
					break;
			}			
			indice++;
		}
		
		System.out.println("------------------------");
		System.out.println(":: ORIENTACAO A OBJETOS ::");
		Pessoa pessoa = new Pessoa();
		pessoa.nome = "Eduardo";
		pessoa.email = "eherique@minsait.com";
		pessoa.endereco = "Minas Gerais";
		pessoa.estudar();		
		pessoa.lazer(2);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.nome = "Ciclano";
		pessoa2.email = "ciclano@a.com";
		pessoa2.endereco = "Endereco Ciclano";
		pessoa2.trabalhar();
		pessoa2.lazer(5);
		
		Pessoa tao = new Pessoa();
		tao.nome = "Tão";
		tao.email = "tao@b.com";
		tao.endereco = "";
		tao.lazer(1);
		
	}

}
