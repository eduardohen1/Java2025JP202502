package br.com.ehmf.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Funcoes {
	public static boolean isNumeric(String numero) {
		try {
			Double d = Double.parseDouble(numero);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static void lerArquivo(String nome) throws FileNotFoundException {
		FileInputStream file = new FileInputStream(nome);
	}
	
	public static void abrirArquivo(String nome) throws FileNotFoundException {
		lerArquivo(nome);
	}
	
}
