package br.unifacisa.p3.banco.exceptions;

public final class SaqueNegativoException extends Exception{
	
	public SaqueNegativoException() {
		super("Valor de saque negativo nao permitido");
	}
}
