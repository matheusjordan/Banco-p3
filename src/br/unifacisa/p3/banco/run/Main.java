package br.unifacisa.p3.banco.run;

import java.util.ArrayList;
import java.util.Scanner;

import br.unifacisa.p3.banco.enums.EOperacoes;
import br.unifacisa.p3.banco.exceptions.DepositoNegativoException;
import br.unifacisa.p3.banco.exceptions.LimiteAtingidoException;
import br.unifacisa.p3.banco.exceptions.LimiteDeMovimentacaoException;
import br.unifacisa.p3.banco.exceptions.LimiteDeSaquesException;
import br.unifacisa.p3.banco.exceptions.SaldoInsuficienteException;
import br.unifacisa.p3.banco.exceptions.SaqueNegativoException;
import br.unifacisa.p3.banco.exceptions.ValorZeroException;
import br.unifacisa.p3.banco.models.ContaCorrente;



public class Main {
	private static Scanner read = new Scanner(System.in);
	
	public static void main(String[] args) {
		ContaCorrente contaC1 = new ContaCorrente(1, 200, "Matheus");
		ContaCorrente contaC2 = new ContaCorrente(2, 700, "Joao");
		ContaCorrente contaC3 = new ContaCorrente(3, 800, "Kiko");
		ContaCorrente contaC4 = new ContaCorrente(4, 900," pedim");
		
		ArrayList<ContaCorrente> contas = new ArrayList<>();
		
		contas.add(contaC1);
		contas.add(contaC2);
		contas.add(contaC3);
		contas.add(contaC4);
		
		while (true) {
			System.out.println("...CONTAS");
			System.out.println("...NUMERO : TITULAR : SALDO...");
			
			for (ContaCorrente conta : contas) {
				System.out.println(conta.getNumero() + " " + conta.getTitular() + " R$ " + conta.getSaldo());
			}
			
			System.out.printf("\nDigite o numero: ");
			int numero = read.nextInt();
			
			menudeoperacoes:
			for (ContaCorrente conta : contas) {
				if (conta.getNumero() == numero) {
					System.out.println("\n...OPERACOES...");
					System.out.printf("1 - Sacar\n2 - depositar\n3 - transferir**\nEscolha uma operacao: ");
					int operacao = read.nextInt();

					iniciarOperacao(conta, operacao);
					break menudeoperacoes;
				}
			}
		}
		
	}
	
	private static void iniciarOperacao(ContaCorrente conta, int operacao) {
		System.out.printf("Digite um valor: ");
		double valor = read.nextDouble();
		
		if (operacao == EOperacoes.DEPOSITAR.getOperacao()) {

			try {
				conta.deposito(valor);
			} catch (DepositoNegativoException dne) {
				System.err.println(dne.getMessage());
			} catch (ValorZeroException zve) {
				System.err.println(zve.getMessage());
			} catch (LimiteAtingidoException lae) {
				System.err.println(lae.getMessage());
			} catch (LimiteDeMovimentacaoException ldme) {
				System.err.println(ldme.getMessage());
			}
			
		} else if (operacao == EOperacoes.SACAR.getOperacao()) {
			try {
				conta.sacar(valor);
			} catch (SaldoInsuficienteException dne) {
				System.err.println(dne.getMessage());
			} catch (ValorZeroException zve) {
				System.err.println(zve.getMessage());
			} catch (SaqueNegativoException sne) {
				System.err.println(sne.getMessage());
			} catch (LimiteDeSaquesException ldse) {
				System.err.println(ldse.getMessage());
			}
			
			
		} else if (operacao == EOperacoes.TRANSFERIR.getOperacao()) {
			System.out.println("Em Construção...");
		}
	}
}
