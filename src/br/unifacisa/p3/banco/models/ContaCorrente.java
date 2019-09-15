package br.unifacisa.p3.banco.models;

import br.unifacisa.p3.banco.enums.ELimites;

public class ContaCorrente extends Conta {
	private double limite = ELimites.CONTACORRENTE.getLimite();
	
	public ContaCorrente(int numero, double valor, String titular) {
		super(numero, valor, titular);
	}

	public double getLimite() {
		return this.limite;
	}

}
