package br.unifacisa.p3.banco.exceptions;

public class LimiteDeMovimentacaoException extends Exception{
	
	public LimiteDeMovimentacaoException() {
		super("Voc� atingiu o valor limite de opera��es!");
	}
}
