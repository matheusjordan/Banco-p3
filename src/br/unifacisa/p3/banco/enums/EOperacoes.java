package br.unifacisa.p3.banco.enums;

public enum EOperacoes {
	SACAR(1), DEPOSITAR(2), TRANSFERIR(3);
	
	private int operacao;
	
	private EOperacoes(int operacao) {
		this.operacao = operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
}
