package br.unifacisa.p3.banco.exceptions;

public final class DepositoNegativoException extends Exception{

	public DepositoNegativoException() {
		super("Valor de deposito negativo nao e permitido");
	}
}
