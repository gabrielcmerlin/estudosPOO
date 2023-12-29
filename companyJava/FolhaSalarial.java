package empresa;

import java.io.IOException;

public class FolhaSalarial {
	// Vetor que contera todos os funcionarios.
	private Funcionario funcionarios[] = new Funcionario[100];
	// Inteiro que armazena quantos funcionarios exitem no vetor acima.
	private int qntdFuncionarios = 0;
	
	public static void main(String[] args) throws IOException {
		int opcao = 0;
		FolhaSalarial fs = new FolhaSalarial();
		
		// Enquanto o usuario nao quiser sair do programa...
		while (opcao != 5) {
			// Lendo acao a ser realizada.
			opcao = leOpcao();
			
			switch (opcao) 
			{
			case 1: // Adicionar Gerente.
				// Lendo as informacoes do Gerente.
				System.out.print("Nome: ");
				String nome = EntradaTeclado.leString();
				System.out.print("CPF: ");
				String cpf = EntradaTeclado.leString();
				System.out.print("Salario Base: ");
				double salarioBase = EntradaTeclado.leDouble();
				
				// Caso o CPF seja valido, adicionando o Gerente na folha salarial.
				if (Funcionario.verificaCPF(cpf) == true) {
					Gerente gerente = new Gerente(nome, cpf, salarioBase);
					fs.adicionaFuncionario(gerente);
					
					System.out.println(" ------- Funcionario adicionado com sucesso -------\n");				
				} else {
					System.out.println(" ------- CPF invalido -------\n");
				}
				
				break;
			case 2: // Adicionar Vendedor.
				// Lendo as informacoes do Vendedor.
				System.out.print("Nome: ");
				nome = EntradaTeclado.leString();
				System.out.print("CPF: ");
				cpf = EntradaTeclado.leString();
				System.out.print("Salario Base: ");
				salarioBase = EntradaTeclado.leDouble();
				System.out.print("Comissão: ");
				double comissao = EntradaTeclado.leDouble();
				
				// Caso o CPF seja valido, adicionando o Vendedor na folha salarial.
				if (Funcionario.verificaCPF(cpf) == true) {
					Vendedor vendedor = new Vendedor(nome, cpf, salarioBase, comissao);
					fs.adicionaFuncionario(vendedor);
					
					System.out.println(" ------- Funcionario adicionado com sucesso -------\n");				
				} else {
					System.out.println(" ------- CPF invalido -------\n");
				}
				
				break;
			case 3: // Adicionar Assistente.
				// Lendo as informacoes do Assistente.
				System.out.print("Nome: ");
				nome = EntradaTeclado.leString();
				System.out.print("CPF: ");
				cpf = EntradaTeclado.leString();
				System.out.print("Salario Base: ");
				salarioBase = EntradaTeclado.leDouble();
				
				// Caso o CPF seja valido, adicionando o Assistente na folha salarial.
				if (Funcionario.verificaCPF(cpf) == true) {
					Assistente assistente = new Assistente(nome, cpf, salarioBase);
					fs.adicionaFuncionario(assistente);
					
					System.out.println(" ------- Funcionario adicionado com sucesso -------\n");				
				} else {
					System.out.println(" ------- CPF invalido -------\n");
				}
				
				break;
			case 4:
				fs.geraFolhaSalarial();
				
				break;
			case 5:
				System.out.println(" ------- Saindo do programa -------\n");
				
				break;
			default:
				System.out.println(" ------- Opção invalida -------\n");
			}			
		}
	}
	
	// Imprime todas as acoes que podem ser realizadas e recebe do usuario qual ele deseja fazer.
	private static int leOpcao() throws IOException {
		int opcao = 0;
		
		System.out.println("1) Adicionar gerente");
		System.out.println("2) Adicionar vendedor");
		System.out.println("3) Adicionar assitente");
		System.out.println("4) Gerar folha salarial");
		System.out.println("5) Sair");
		
		System.out.print("Digite a opcao desejada: ");
		opcao = EntradaTeclado.leInt();			
		
		return opcao;
	}
	
	// Coloca um novo funcionario no vetor e atualiza a quantidade de funcionarios.
	private void adicionaFuncionario(Funcionario funcionario) {
		this.funcionarios[this.qntdFuncionarios++] = funcionario;
	}
	
	// Calcula a soma de todos os salarios e imprime-a junto com a quantidade de funcionarios.
	private void geraFolhaSalarial() {
		int valorTotal = 0;
		
		for (int i = 0; i < this.qntdFuncionarios; i++) {
			valorTotal += funcionarios[i].calculaSalario();
		}
		
		System.out.println("Quantidade de funcionarios: " + this.qntdFuncionarios);
		System.out.println("Folha Salarial: R$" + valorTotal + "\n");
	}
}