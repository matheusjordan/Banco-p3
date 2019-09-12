package br.unifacisa.p3.banco.exceptions;

public class LimiteAtingidoException extends Exception {
	
	public LimiteAtingidoException() {
		super("Limite da conta atingido!");
	}
}
