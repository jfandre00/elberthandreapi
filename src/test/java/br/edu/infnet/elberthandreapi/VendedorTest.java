package br.edu.infnet.elberthandreapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.infnet.elberthandreapi.model.domain.Vendedor;

public class VendedorTest {

	@Test
	void testCalcularBonus_SemBonus() {
		// preparação
		Vendedor vendedor = new Vendedor();
		vendedor.qtdeVendas = 1;
		vendedor.salario = 10;
		
		// execução
		double bonusCalculado = vendedor.calcularBonus();
		
		// verificação
		assertEquals(0, bonusCalculado);
		// 0 é o valor esperado, considerando a lógica do calcularBonus
		
		
	}
	
	@Test
	void testCalcularBonus_ComBonus() {
		// preparação
		Vendedor vendedor = new Vendedor();
		vendedor.qtdeVendas = 10;
		vendedor.salario = 1000;
		
		// execução
		double bonusCalculado = vendedor.calcularBonus();
		
		// verificação
		assertEquals(200, bonusCalculado);
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