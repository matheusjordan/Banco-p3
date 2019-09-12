package br.unifacisa.p3.banco.exceptions;

public class SaqueInvalidoException extends Exception{
	
	public SaqueInvalidoException() {
		super("Impossivel sacar um valor maior que seu saldo");
	}
}
