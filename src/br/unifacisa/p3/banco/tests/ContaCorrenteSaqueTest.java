package br.unifacisa.p3.banco.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.unifacisa.p3.banco.exceptions.LimiteDeSaquesException;
import br.unifacisa.p3.banco.exceptions.SaldoInsuficienteException;
import br.unifacisa.p3.banco.exceptions.SaqueNegativoException;
import br.unifacisa.p3.banco.exceptions.ValorZeroException;
import br.unifacisa.p3.banco.models.ContaCorrente;

public class ContaCorrenteSaqueTest {
	private ContaCorrente c0, c1, c2, c4, c5;
	
	@Before
	public void setUp() {
		this.c0 = new ContaCorrente(1, 500, "Matheus Jordan");
		this.c1 = new ContaCorrente(2, 500, "Xupacu");
		this.c2 = new ContaCorrente(3, 500, "Regina casé");
		this.c4 = new ContaCorrente(4, 5001, "Mc Kapela");
		this.c5 = new ContaCorrente(5, 5000, "Mc Lan");
	}

	@Test(expected = SaldoInsuficienteException.class)
	public void testSaqueMaiorQueSaldo() throws SaldoInsuficienteException {
		try {
			this.c0.sacar(501);
		} catch (SaldoInsuficienteException sie) {
			throw new SaldoInsuficienteException();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testSaqueIguaoAoSaldo() {
		try {
			c1.sacar(500);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(0, c1.getSaldo(), 0);
		
	}
	
	@Test
	public void testSaqueMenorQueSaldo() {
		try {
			c2.sacar(499);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		assertEquals(1, c2.getSaldo(), 1);
	}
	
	@Test(expected = LimiteDeSaquesException.class)
	public void testLimiteDeSaques() throws LimiteDeSaquesException{
		try {
			c4.sacar(5001);
		} catch (LimiteDeSaquesException ldse) {
			throw new LimiteDeSaquesException();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testSaqueIgualAoLimite() {
		try {
			this.c5.sacar(5000);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(0, c5.getSaldo(), 0);
	}
	
	@Test(expected = SaqueNegativoException.class)
	public void testSaqueComValorNegativo() throws SaqueNegativoException {
		try {
			this.c0.sacar(-1);
		} catch (SaqueNegativoException sne) {
			throw new SaqueNegativoException();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test(expected = ValorZeroException.class)
	public void testSaqueValorZero() throws ValorZeroException {
		try {
			this.c0.sacar(0);
		} catch (ValorZeroException svz) {
			throw new ValorZeroException();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	

}
