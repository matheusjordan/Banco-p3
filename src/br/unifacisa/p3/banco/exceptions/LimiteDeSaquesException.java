package br.unifacisa.p3.banco.exceptions;

public class LimiteDeSaquesException extends Exception {
	
	public LimiteDeSaquesException() {
		super("Você atingiu o valor limite de saques de sua conta");
	}
}
