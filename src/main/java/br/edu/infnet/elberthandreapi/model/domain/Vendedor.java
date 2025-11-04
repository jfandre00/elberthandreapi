package br.edu.infnet.elberthandreapi.model.domain;

public class Vendedor {

	public String nome; // valor padrão é null
	public double salario; // valor padrão é 0.0
	public int qtdeVendas; // valor padrão é 0
	
	
	public Vendedor() {
		nome = "Vendedor Temporário";
		salario = 1;
		qtdeVendas = 1;
	}
	
	public double calcularBonus() {
		// Requisitos funcionais: Bônus extra de R$ 200,00 ao salario 
		// se ele tiver feito mais de 8 vendas e se o seu salário base for menor que R$ 2000,00
		
		if(qtdeVendas > 8 && salario < 2000) {
			return 200;
		}
		return 0;
	}
	
	
	public double calcularComissao() { 
		
		// um método só pode fazer uma única coisa.
		
		// Requisitos funcionais: Comissão dinâmica
		// até 5 vendas - comissão por venda R$ 30,00
		// entre 6 a 10 vendas - comissão por venda R$ 50,00
		// acima de 10 vendas - comissão por venda R$ 75,00
		
		
		if(qtdeVendas >= 1 && qtdeVendas <= 5) {
			return 30;
		}
		
		else if(qtdeVendas >= 6 && qtdeVendas <= 10) {
			return 50;
		}
		else if (qtdeVendas > 10){ 
			return 75;
		}
		
		return 0;
		
		
	}
	
	public double calcularSalario() {
		
		double comissao = calcularComissao();
		
		double bonus = calcularBonus();
		
		return salario + comissao + bonus;
	}
	
	/* Classificação do vendedor - 0 a 3 vendas - Vendedor Iniciante / 4 a 7 vendas - Vendedor Junior 
	 8 a 12 vendas - Vendedor Pleno / acima de 12 vendas - Vendedor Senior */
	
	private String obterCategoria() {
		
		if(qtdeVendas >=0 && qtdeVendas <=3) {
			return "Vendedor Iniciante";
		}
		else if(qtdeVendas >=4 && qtdeVendas <=7) {
			return "Vendedor Junior";
		}
		else if(qtdeVendas >=8 && qtdeVendas <=12) {
			return "Vendedor Pleno";
		}
		else {
			return "Vendedor Senior";
		}
	}
	
	/*
	private String obterCategoriaSwitch() {
		
		switch (qtdeVendas) {
		case 0, 1, 2, 3:
			return "Vendedor Iniciante";
		case 4, 5, 6, 7:
			return "Vendedor Junior";
		case 8, 9, 10, 11, 12:
			return "Vendedor Pleno";
		default:
			return "Vendedor Senior";
		}
	}
	*/
	
	public void imprimir() { // método público, qualquer classe pode acessar esse método
		
		double salarioLiquido = calcularSalario();
		
		String categoria = obterCategoria();
		
		System.out.println("Valor Total = " + salarioLiquido);	
		
		System.out.println("O "+ categoria + " " + nome + " foi cadastrado com sucesso!!" );
		
	}
	

	
	

	
	
}
