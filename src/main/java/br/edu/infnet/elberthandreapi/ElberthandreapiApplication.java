package br.edu.infnet.elberthandreapi;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.infnet.elberthandreapi.model.domain.Vendedor; 

@SpringBootApplication
public class ElberthandreapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElberthandreapiApplication.class, args);
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Iniciando...");
		
		
		// Instanciar um objeto da classe Vendedor
		
		Vendedor vendedorElberth = new Vendedor();	
		System.out.print("Digite o nome do vendedor: ");
		vendedorElberth.nome = in.nextLine();  //"Elberth";	
		
		System.out.print("Informe o salário do vendedor: ");
		if(!in.hasNextDouble()) { // validação de entrada, se o usuário digitar um valor inválido - método boolean
			System.out.println("O salário do vendedor está inválido!!");
			in.next(); // irá atribuir o valor 0 
			
		} else {
			// vamos fazer o tratamento para verificar se o valor é menor que zero
			double salario = in.nextDouble();
			
			if(salario < 0) {
				System.out.println("O salário não pode ser menor que zero!!");
				// como o valor padrão de double é 0.0, não preciso atribuir nada e o salário já ficará com esse valor
			} else {
				vendedorElberth.salario = salario;
			}
		}
		
		
		System.out.print("Informe a quantidade de vendas do vendedor: ");
		if (!in.hasNextInt()) { // validação de entrada, se o usuário digitar um valor inválido - método boolean
			System.out.println("A quantidade de vendas do vendedor está inválida!!");
			in.next(); // irá atribuir o valor 0 
			
		} else {
			
			int qtdeVendas = in.nextInt();
			if (qtdeVendas < 0) {
				System.out.println("A quantidade de vendas não pode ser menor que zero!!");
				// como o valor padrão de int é 0, não preciso atribuir nada e a qtdeVendas já ficará com esse valor
			} 
			else {
				vendedorElberth.qtdeVendas = qtdeVendas;
			}
		}
		
		
		vendedorElberth.imprimir();
		
		System.out.println("Finalizando...");
		
		in.close(); // fechando o scanner
		
	}

}
