package br.unifacisa.p3.banco.enums;

public enum Limites {
	CONTACORRENTE(5000),
	COTAPOUPANCA(2000);
	
	private double valor;
	
	private Limites(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}
}
