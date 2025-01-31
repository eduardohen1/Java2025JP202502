package br.com.ehmf.exception;

public class LimitePixExcedidoException extends Exception {

	private Double quantiaExcedida;
	
	//construtor
	public LimitePixExcedidoException(Double quantiaExcedida) {
		super("Limite de PIX excedido por 🤣: " + quantiaExcedida);
		this.quantiaExcedida = quantiaExcedida;
	}
	
	public Double getQuantiaExcedida() {
		return this.quantiaExcedida;
	}
	
}
