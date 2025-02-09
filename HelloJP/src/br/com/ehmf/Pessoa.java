package br.com.ehmf;

public class Pessoa {
	
	//atributos
	private String nome;
	private String endereco;
	private String email;
	
	//construtor(es)
	public Pessoa(String nome, String endereco, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
	}
	
	public Pessoa(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.endereco = "-";
	}
	
	//GETs SETs
	public String getNome() {
		//crio uma auditoria de quem está pegando o nome
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
			
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}

	//métodos
	public void trabalhar() {
		System.out.println(nome + " indo para o trabalho");
	}
	
	public void estudar() {
		System.out.println(nome + " indo estudar");
	}
	
	/**
	 * Metodo lazer
	 * @param tipoLazer
	 * <li><strong>0</strong> - Passear com o pet</li>
	 * <li><strong>1</strong> - Ir Crossfit</li>
	 * <li><strong>2</strong> - Filme no Netflix</li>
	 * <li><strong>3</strong> - Dormir</li>
	 * <li><strong>Outros</strong> - Ficar de boa</li>
	 */
	public void lazer(int tipoLazer) {
		switch(tipoLazer) {
			case 0:
				System.out.println(nome + ", passear com o pet");
				break;
			case 1:
				System.out.println(nome + ", ir para o Crossfit 😢😢");
				break;
			case 2:
				System.out.println(nome + ", tentar achar um filme no Netflix...");
				break;
			case 3:
				//documentar a chamada da função
				//posso criar uma auditoria sobre isso.
				System.out.println(">>>>> AUDITORIA: dfjaldfjalsfla");
				dormir();
				break;
			default:
				System.out.println(nome + ", hora de ficar de boa");
				break;
		}		
	}
	
		
	private void dormir() {
		System.out.println("Colocar pijama");
		System.out.println("Arrumar a cama");
		System.out.println("Dormir");
	}
	
	public void save() {
		System.out.println("Salvar pessoa no Banco de Dados");
	}
	
}
