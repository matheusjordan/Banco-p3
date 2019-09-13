package br.unifacisa.p3.banco.models;

import br.unifacisa.p3.banco.exceptions.LimiteAtingidoException;
import br.unifacisa.p3.banco.exceptions.SaqueNegativoException;
import br.unifacisa.p3.banco.exceptions.ValorZeroException;
import br.unifacisa.p3.banco.interfaces.Limitavel;

public abstract class Conta implements Limitavel {
	private double saldo;
	private int numero;
	
	public Conta(int numero) {
		this.numero = numero;
	}
	
	public Conta(int numero, double saldo) {
		this(numero);
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public final void sacar(double valor) throws ValorZeroException, SaqueNegativoException, LimiteAtingidoException{
		if (valor == 0) throw new ValorZeroException();
		else if (valor < 0) throw new SaqueNegativoException();
		else if (valor > this.saldo) throw new LimiteAtingidoException();
		
		this.saldo -= valor;
	}
	
	public final void deposito(double valor) throws ValorZeroException, SaqueNegativoException{
		if (valor == 0) throw new ValorZeroException();
		else if (valor < 0) throw new SaqueNegativoException();
		
		this.saldo += valor;
	}
}
