package br.unifacisa.p3.banco.exceptions;

public class LimiteDeMovimentacaoException extends Exception{
	
	public LimiteDeMovimentacaoException() {
		super("Você atingiu o valor limite de operações!");
	}
}
