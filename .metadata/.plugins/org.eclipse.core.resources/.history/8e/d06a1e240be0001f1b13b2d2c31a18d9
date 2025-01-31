package br.com.ehmf.utils;

import br.com.ehmf.exception.LimitePixExcedidoException;

public class ContaBancaria {
	
	private Double limitePix = 2000.0; //limite diario de transferencia
	
	public ContaBancaria() {
		
	}
	
	public ContaBancaria(Double limitePix) {
		this.limitePix = limitePix;
	}
	
	public void fazerPix(Double quantia) throws LimitePixExcedidoException {
		if(quantia > this.limitePix) {
			//lancar excecao
			throw new LimitePixExcedidoException(quantia - this.limitePix);
		}else {
			System.out.println("PIX realizado com sucesso!");
		}
	}

}
