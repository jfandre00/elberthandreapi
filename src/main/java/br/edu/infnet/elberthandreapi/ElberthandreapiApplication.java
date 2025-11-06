package br.edu.infnet.elberthandreapi;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.infnet.elberthandreapi.model.domain.Vendedor; 

@SpringBootApplication
public class ElberthandreapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElberthandreapiApplication.class, args);
		
		final int MAX_TENTATIVAS = 3; // constante e não pode ser alterada pois colocamos o modificador final
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Iniciando...");
		
		int opcao = 0;
		do {
			System.out.println("1 - Incluir vendedor");
			System.out.println("9 - Sair");
			System.out.println("Escolha a opção desejada:");
			opcao = in.nextInt();
			in.nextLine(); // <<< limpa o buffer após nextInt
			switch (opcao) {
			case 1:
				
				// Instanciar um objeto da classe Vendedor
				Vendedor vendedor = new Vendedor();	
				
				System.out.print("Digite o nome do vendedor: ");
				vendedor.setNome(in.nextLine());  //"Elberth";	
				
				System.out.print("Informe o salário do vendedor: ");
				if(!in.hasNextDouble()) { // validação de entrada, se o usuário digitar um valor inválido - método boolean
					String campo = in.next(); // lê o valor inválido
					
					System.out.println("O salário do vendedor está inválido!! [" + campo + "]");
					in.next(); // irá atribuir o valor 0 
					
				} else {
					// vamos fazer o tratamento para verificar se o valor é menor que zero
					double salario = in.nextDouble();
					
					if(salario < 0) {
						System.out.println("O salário não pode ser menor que zero!!");
						// como o valor padrão de double é 0.0, não preciso atribuir nada e o salário já ficará com esse valor
					} else {
						vendedor.setSalario(salario);
					}
				}
				
				in.nextLine(); // <<< limpa o buffer após nextDouble
				
				
				//--------------- Quantidade de vendas ----------------- 
				
				
				int tentativas = 0;  
				do {
					
					System.out.print("Informe a quantidade de vendas do vendedor: ");
					if (!in.hasNextInt()) { // validação de entrada, se o usuário digitar um valor inválido - método boolean
						System.out.println("A quantidade de vendas do vendedor está inválida!!");
						in.next(); // irá atribuir o valor 0 
						
					} else {
						
						int qtdeVendas = in.nextInt();
						in.nextLine(); 
						
						if (qtdeVendas < 0) {
							System.out.println("A quantidade de vendas está negativa ["+ qtdeVendas + "]!!!!");
							tentativas++;
							// como o valor padrão de int é 0, não preciso atribuir nada e a qtdeVendas já ficará com esse valor
							
						} else {
							vendedor.setQtdeVendas(qtdeVendas);
							
							if (qtdeVendas == 0) {
								System.out.println("Esse vendedor não teve vendas neste período e não receberá comissão extra!!");
							}
							break; // sai do loop do-while
						}
					}
					
				} while (tentativas < MAX_TENTATIVAS);		
				
				// --------------- Exibir os dados do vendedor -----------------
				
				vendedor.imprimir();
				int opcaoDetalhe = 0;
				
				do {
				System.out.println("1 - Valor do cálculo salarial");
				System.out.println("2 - Comissão calculada");
				System.out.println("3 - Bônus calculado");
				System.out.println("9 - Sair");
				System.out.println("Qual detalhe do vendedor você deseja ver?");
				
				opcaoDetalhe = in.nextInt();
				switch (opcaoDetalhe) {
				case 1:
					System.out.println("Cálculo salarial " + vendedor.calcularSalario());
					break;
				case 2:
					System.out.println("Comissão calculada " + vendedor.calcularComissao());
					break;
				case 3:
					System.out.println("Bônus calculado " + vendedor.calcularBonus());
					break;
					
				case 9:
					System.out.println("Saída");
					break;
					
				default:
					System.out.println("Opção inválida, tente novamente!!");
					break;
				}
				} while (opcaoDetalhe != 9);
					
				
				
				
				
				// 
			
				break;	
			case 9:
				System.out.println("Finalizando o sistema...");
				break;
			
			default:
				System.out.println("Qualquer outra opção!!");
				break;
			}
		} while (opcao != 9);
		

		
		
	
		/*
		int qtdeVendedores = 0;
		
		System.out.print("Informe a quantidade de vendedores que deseja cadastrar: ");
		if (!in.hasNextInt()) { // validação de entrada, se o usuário digitar um valor inválido - método boolean
			System.out.println("A quantidade de vendedores está inválida!!");
			in.next(); // irá atribuir o valor 0 
			
		} else {
			
			qtdeVendedores = in.nextInt();
			if (qtdeVendedores <= 0) {
				System.out.println("A quantidade de vendedores está negativa ou zerada ["+ qtdeVendedores+ "]!!");
				
				qtdeVendedores = 1;
			} 
			
		}
		
		
		/* Limpando o buffer do Scanner antes de iniciar o loop */
		in.nextLine(); // <<< limpa o buffer antes do loop
		
		
		
		System.out.println("Finalizando...");
		
		in.close(); // fechando o scanner
		
	}

}
