package br.edu.infnet.elberthandreapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.infnet.elberthandreapi.model.domain.Vendedor;

public class VendedorTest {

	@Test
	void testCalcularBonus_SemBonus_ComQtdeEntreZeroETres() {
		// preparação
		Vendedor vendedor = new Vendedor();
		vendedor.setNome("Elberth");
		vendedor.setQtdeVendas(1);
		vendedor.setSalario(10);
		
		// execução
		double bonusCalculado = vendedor.calcularBonus();
		vendedor.imprimir();
		
		// verificação
		assertEquals(0, bonusCalculado);
		// 0 é o valor esperado, considerando a lógica do calcularBonus
		
		
	}
	
	@Test
	void testCalcularBonus_ComBonus() {
		// preparação
		Vendedor vendedor = new Vendedor();
		vendedor.setNome("Elberth");
		vendedor.setQtdeVendas(10);
		vendedor.setSalario(1000);
		
		// execução
		double bonusCalculado = vendedor.calcularBonus();
		vendedor.imprimir();
		
		// verificação
		assertEquals(200, bonusCalculado);
		// 0 é o valor esperado, considerando a lógica do calcularBonus
		
		
	}
	
	@Test
	void testCalcularBonus_SemBonus_ComQtdeEntreQuatroESete() {
		// preparação
		Vendedor vendedor = new Vendedor();
		vendedor.setNome("Elberth");
		vendedor.setQtdeVendas(5);
		vendedor.setSalario(10);
		
		// execução
		double bonusCalculado = vendedor.calcularBonus();
		vendedor.imprimir();
		
		// verificação
		assertEquals(0, bonusCalculado);
		// 0 é o valor esperado, considerando a lógica do calcularBonus
		
		
	}
	
	@Test
	void testCalcularBonus_SemBonus_ComQtdeMaiorQue12() {
		// preparação
		Vendedor vendedor = new Vendedor();
		vendedor.setNome("Elberth");
		vendedor.setQtdeVendas(15);
		vendedor.setSalario(10);
		
		// execução
		double bonusCalculado = vendedor.calcularBonus();
		vendedor.imprimir();
		
		// verificação
		assertEquals(200, bonusCalculado);
		
		
	}
	
	@Test
	void testCalcularBonus_SemBonus_ComQtdeVendasZerada() {
		// preparação
		Vendedor vendedor = new Vendedor();
		vendedor.setNome("Elberth");
		vendedor.setQtdeVendas(0);
		vendedor.setSalario(10);
		
		// execução
		double bonusCalculado = vendedor.calcularBonus();
		vendedor.imprimir();
		
		// verificação
		assertEquals(0, bonusCalculado);
		// 0 é o valor esperado, considerando a lógica do calcularBonus
		
		
	}
	
	
	
}

/*

public double calcularBonus() {

if(qtdeVendas > 8 && salario < 2000) {
	return 200;
}
return 0;
}

*/