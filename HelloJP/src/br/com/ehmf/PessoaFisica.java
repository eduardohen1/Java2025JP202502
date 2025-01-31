package br.com.ehmf;

public class PessoaFisica extends Pessoa {	
	
	//atributos
	private String cpf;
	
	//contrator
	public PessoaFisica(String nome, String endereco, String email, 
			            String cpf) {
		super(nome, endereco, email);
		this.cpf = cpf;
	}
	
	//GETs SETs
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
