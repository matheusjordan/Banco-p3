package br.unifacisa.p3.banco.enums;

public enum ELimites {
	CONTACORRENTE(5000),
	COTAPOUPANCA(2000);
	
	private double limite;
	
	private ELimites(double valor) {
		this.limite = valor;
	}
	
	public double getLimite() {
		return this.limite;
	}
}
