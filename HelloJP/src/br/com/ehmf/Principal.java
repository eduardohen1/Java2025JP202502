package br.com.ehmf;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.ehmf.exception.LimitePixExcedidoException;
import br.com.ehmf.utils.ContaBancaria;
import br.com.ehmf.utils.Funcoes;

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
		
		//POO
		System.out.println("------------------------");
		System.out.println(":: ORIENTACAO A OBJETOS ::");
		/*Pessoa pessoa = new Pessoa();
		pessoa.nome = "Eduardo";
		pessoa.email = "eherique@minsait.com";
		pessoa.endereco = "Minas Gerais";*/
		Pessoa pessoa = new Pessoa("Eduardo", "Endereco", "email");
		pessoa.estudar();		
		pessoa.lazer(2);
		pessoa.setNome("Eduardo Henrique");		
		System.out.println("* Nome: "     + pessoa.getNome());
		System.out.println("* Endereco: " + pessoa.getEndereco());
		System.out.println("* E-mail: "   + pessoa.getEmail());
		
		/*Pessoa pessoa2 = new Pessoa();
		pessoa2.nome = "Ciclano";
		pessoa2.email = "ciclano@a.com";
		pessoa2.endereco = "Endereco Ciclano";*/
		Pessoa pessoa2 = new Pessoa("Ciclano", "Endereco", "email");
		pessoa2.trabalhar();
		pessoa2.lazer(5);
		
		/*Pessoa tao = new Pessoa();
		tao.nome = "Tão";
		tao.email = "tao@b.com";
		tao.endereco = "";*/
		Pessoa tao = new Pessoa("Tão", "Endereco", "Email");
		tao.lazer(1);
		tao.lazer(3);
		
		Pessoa jao = new Pessoa("Jão", "jao@jao.com");
		jao.setEndereco("Novo endereco");
		System.out.println("* Nome: "     + jao.getNome());
		System.out.println("* Endereco: " + jao.getEndereco());
		System.out.println("* E-mail: "   + jao.getEmail());
		
		//HERANÇA
		PessoaFisica pessoaFisica = new PessoaFisica("Nome", "Endereco",
				                                "Email", "cpf");
		System.out.println("* Nome: "     + pessoaFisica.getNome());
		System.out.println("* Endereco: " + pessoaFisica.getEndereco());
		System.out.println("* E-mail: "   + pessoaFisica.getEmail());
		System.out.println("* CPF: "      + pessoaFisica.getCpf());
		System.out.println("--------------------");
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica(
				"Nome Juridico", "Endereco", "Email",
				"Nome Fantasia", "CNPJ");
		
		System.out.println("* Nome: "          + pessoaJuridica.getNome());
		System.out.println("* Endereco: "      + pessoaJuridica.getEndereco());
		System.out.println("* E-mail: "        + pessoaJuridica.getEmail());
		System.out.println("* Nome fantasia: " + pessoaJuridica.getNomeFantasia());
		System.out.println("* CNPJ: "          + pessoaJuridica.getCnpj());
		
		System.out.println("--------------------");		
		PessoaJuridica pessoaJuridica2 = new PessoaJuridica(
				"Nome Juridico2", "Endereco2", "Email2",
				"Nome Fantasia2", "CNPJ2",1);
		
		System.out.println("* Nome: "          + pessoaJuridica2.getNome());
		System.out.println("* Endereco: "      + pessoaJuridica2.getEndereco());
		System.out.println("* E-mail: "        + pessoaJuridica2.getEmail());
		System.out.println("* Nome fantasia: " + pessoaJuridica2.getNomeFantasia());
		System.out.println("* CNPJ: "          + pessoaJuridica2.getCnpj());
		
		//POLIMORFISMO
		System.out.println("--------------------");
		boolean ehPessoaFisica = false;
		Pessoa pessoaNet;
		// receber dados de outro servidor (BD, API, XML) e depois vejo se
		//  ele é Pessoa Física ou Juridica;
		String xml = "asdfasdfasfa";
		// tratar o xml para virar Objeto:
		// depois de tratado identifiquei que os dados são de 
		//  pessoa Física.
		ehPessoaFisica = false;
		
		if(ehPessoaFisica) {
			pessoaNet = new PessoaFisica("Zé", "End Ze", "Email do Ze",
					                     "CPF do Ze");
		}else {
			pessoaNet = new PessoaJuridica("Zé", "End Ze", "Email do Ze",
					                       "Lojinha do Ze", "CNPJ");
		}
		pessoaNet.save();
		
		//TRATAMENTO DE EXCEÇÕES
		System.out.println("--------------------");
		System.out.println(":: TRATAMENTO DE EXCECOES ::");
		
		int valor = 10;
		System.out.println("Vou fazer a divisao!");		
		int resposta = 0;
		int divisao = 0;
		try {
			resposta = valor / divisao;
			System.out.println("Resposta: " + resposta);
			
			int[] correcoes = {1,6,7,10,4};
			for(int i = 0; i < 5; i++) {
				System.out.println(">Correcoes: " + correcoes[i]);
			}			
			
		}catch(ArithmeticException e) {
			System.err.println("ERROR ARITIMETICO! " + e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("ERROR ARRAY! " + e.getMessage());
		}catch (Exception e) {
			System.err.println("ERROR GENERICO! " + e.getMessage());
		}
		
		int correcao = resposta + 2;
		System.out.println("A correcao monetaria e de R$" + correcao);
		
		//THOWS
		String retornoWeb = "5";
		if(Funcoes.isNumeric(retornoWeb)) {
			System.out.println("A variavel retornoWeb é numerica!");
		}else {
			System.out.println("A variavel retornoWeb NAO é numerica!");
		}
		
		try {
			String nomeArquivo = "Principal.class";
			Funcoes.abrirArquivo(nomeArquivo);
		}catch(FileNotFoundException e) {
			System.err.println("ERROR! " + e.getMessage());
		}
		System.out.println("Segui a execucao do prog!😀");
		
		//Exceção personalizada
		ContaBancaria contaBancaria1 = new ContaBancaria(1000.0);
		ContaBancaria contaBancaria2 = new ContaBancaria();
		
		try {
			contaBancaria1.fazerPix(999.0);
			contaBancaria2.fazerPix(1500.0);
		}catch (LimitePixExcedidoException e) {
			System.err.println("ERROR! " + e.getMessage());
		}
		
		System.out.println("Transferencia feita");
		
		//COLECOES:
		System.out.println("--------------------");
		System.out.println(":: COLECOES ::");
		
		List<String> nomes = new ArrayList<String>();
		nomes.add("Maria");
		nomes.add("Joao");
		nomes.add("Alex");
		nomes.add("Jose");
		nomes.add("Abel");
		nomes.add("Carla");
		nomes.add("Fernanda");
		nomes.add("Ana");		
				
		/*for(int ind = 0; ind < nomes.size(); ind++) {
			String nome = nomes.get(ind);
			System.out.println("* Nome: " + nome);
		}*/
		
		//foreach <- C#, Javascript
		for(String nome : nomes) {
			System.out.println("* Nome: " + nome);
		}
		System.out.println("--------------------");
		
		//Ordenar minha lista:
		
		Collections.sort(nomes);		
		for(String nome : nomes) {
			System.out.println("* Nome: " + nome);
		}
		
		System.out.println("--------------------");
		//filtrar todos que comecem com a letra J
		List<String> nomesFiltrados = nomes.stream()
				.filter(nome -> nome.startsWith("J")) //lambda
				.collect(Collectors.toList());
		/*
		 * Forma longa do código acima:		
		List<String> listaNova = new ArrayList<String>();
		for(String nome : nomes) {
			if(nome.startsWith("J")) {
				listaNova.add(nome);
			}			
		}
		*/
		//filtrar todos que comecem com a letra A
		nomesFiltrados = nomes.stream()
				.filter(nome -> nome.startsWith("A")) //lambda
				.collect(Collectors.toList());
		
		System.out.println("--------------------");
		
		//-------------------------------------
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa);
		pessoas.add(pessoa2);
		pessoas.add(tao);
		pessoas.add(jao);		
		System.out.println("Lista de pessoas:");
		for(Pessoa p : pessoas) {
			System.out.println("* Nome: " + p.getNome() + 
					" | E-mail: " + p.getEmail());
		}
		
		//COLECOES - SET:
		System.out.println("--------------------");
		System.out.println(":: COLECOES - SET ::");
		Set<String> cores = new HashSet<String>();
		cores.add("Azul");
		cores.add("Amarelo");
		cores.add("Verde");
		cores.add("Roxo");
		cores.add("Roxo");		
		for(String cor : cores) {
			System.out.println("Cor: " + cor);
		}
		
		//COLECOES - HASHMAP:
		System.out.println("--------------------");
		System.out.println(":: COLECOES - HASHMAP ::");
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("Brasil", "Brasilia");
		paises.put("Franca", "Paris");
		paises.put("Portugal", "Lisboa");
		System.out.println("Capitais: ");
		//imprimir a lista das capitais:
		for(Map.Entry<String, String> capital : paises.entrySet()) {
			System.out.println(" - " + capital.getValue());
		}
		
		System.out.println("--------------------");
		Map<Integer, Pessoa> mapPessoas = new HashMap<Integer, Pessoa>();
		mapPessoas.put(1, pessoa);
		mapPessoas.put(2, pessoa2);
		mapPessoas.put(3, jao);
		
		System.out.println("Pessoa do Jao: " + jao.getNome());
		System.out.println("Pessoa do Jao no map: " + mapPessoas.get(3).getNome());
		
		
	}

}
