package br.com.ehmf;

public class PessoaJuridica extends Pessoa {
	
	//Atributos
	private String nomeFantasia;
	private String cnpj;
	
	//construtor
	public PessoaJuridica(String nome, String endereco, String email,
			              String nomeFantasia, String cnpj) {
		super(nome, endereco, email);
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}
	
	public PessoaJuridica(String nome, String email,
                          String nomeFantasia, String cnpj) {
		super(nome, email);
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}
	
	public PessoaJuridica(String nome, String endereco, String email,
		            String nomeFantasia, String cnpj, int i) {
		super(nome, email);
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		super.setEndereco(endereco);
	}

	//GETs SETs
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	

}
