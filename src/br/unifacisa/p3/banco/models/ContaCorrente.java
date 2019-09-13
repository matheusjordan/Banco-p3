package br.unifacisa.p3.banco.models;

import br.unifacisa.p3.banco.enums.Limites;

public class ContaCorrente extends Conta {
	private double limite = Limites.CONTACORRENTE.getValor();
	
	public ContaCorrente(int numero, double valor, double limite) {
		super(numero, valor);
	}

	public double getLimite() {
		return 0;
	}
}
