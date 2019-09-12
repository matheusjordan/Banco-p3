package br.unifacisa.p3.banco.exceptions;

public class ValorZeroException extends Exception{

	public ValorZeroException() {
		super("Impossivel Sacar ou Depositar R$ 0");
	}
}
