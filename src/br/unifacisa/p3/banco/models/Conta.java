package br.unifacisa.p3.banco.models;

import br.unifacisa.p3.banco.enums.ELimites;
import br.unifacisa.p3.banco.enums.EOperacoes;
import br.unifacisa.p3.banco.exceptions.DepositoNegativoException;
import br.unifacisa.p3.banco.exceptions.LimiteAtingidoException;
import br.unifacisa.p3.banco.exceptions.LimiteDeMovimentacaoException;
import br.unifacisa.p3.banco.exceptions.LimiteDeSaquesException;
import br.unifacisa.p3.banco.exceptions.SaldoInsuficienteException;
import br.unifacisa.p3.banco.exceptions.SaqueInvalidoException;
import br.unifacisa.p3.banco.exceptions.SaqueNegativoException;
import br.unifacisa.p3.banco.exceptions.ValorZeroException;
import br.unifacisa.p3.banco.interfaces.Limitavel;

public abstract class Conta implements Limitavel {
	private double saldo;
	private int numero;
	private String titular;
	private double totalSacado;
	private double totalDepositado;

	public Conta(int numero) {
		this.numero = numero;
	}
	
	public Conta(int numero, double saldo) {
		this(numero);
		this.saldo = saldo;
	}
	
	public Conta(int numero, double saldo, String titular) {
		this(numero, saldo);
		this.titular = titular;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public int getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}
	
	public double getTotalSacado() {
		return totalSacado;
	}

	public double getTotalDepositado() {
		return totalDepositado;
	}

	public final void sacar(double valor) throws ValorZeroException, SaqueNegativoException, SaldoInsuficienteException, LimiteDeSaquesException{
		if (valor == 0) throw new ValorZeroException();
		else if (valor < 0) throw new SaqueNegativoException();
		else if (valor > this.saldo) throw new SaldoInsuficienteException();
		
		double tempTotalSacado = this.totalSacado + valor;
		
		if (tempTotalSacado <= ELimites.CONTACORRENTE.getLimite()) {
			this.totalSacado = tempTotalSacado;
			this.saldo -= valor;
		} else {
			throw new LimiteDeSaquesException();
		}
		
	}
	
	public final void deposito(double valor) throws LimiteAtingidoException, LimiteDeMovimentacaoException, ValorZeroException, DepositoNegativoException{
		if (valor == 0) throw new ValorZeroException();
		else if (valor < 0) throw new DepositoNegativoException();
		else if (valor >= this.getLimite() ) throw new LimiteDeMovimentacaoException();
		else if ((this.saldo + valor) > this.getLimite()) throw new LimiteAtingidoException();
		
		this.saldo += valor;
	}

}
