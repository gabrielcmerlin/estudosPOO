from Funcionario import Funcionario
from Gerente import Gerente
from Vendedor import Vendedor
from Assistente import Assistente

class FolhaSalarial:
    def __init__(self):
        # Cada folha salarial possui um vetor de funcionarios e um inteiro que diz quantos funcionarios existem.
        self.funcionarios = []
        self.qntdFuncionarios = 0

    # Imprime todas as acoes que podem ser realizadas e recebe do usuario qual ele deseja fazer.
    def leOpcao():
        print("1) Adicionar gerente")
        print("2) Adicionar vendedor")
        print("3) Adicionar assitente")
        print("3) Adicionar assitente")
        print("4) Gerar folha salarial")
        print("5) Sair")

        print("Digite a opcao desejada: ", end = "")
        opcao = int(input())

        return opcao

    # Coloca um novo funcionario no vetor e atualiza a quantidade de funcionarios.
    def adicionaFuncionario(self, funcionario):
        self.funcionarios.append(funcionario)
        self.qntdFuncionarios += 1

    # Calcula a soma de todos os salarios e imprime-a junto com a quantidade de funcionarios.
    def geraFolhaSalarial(self):
        valorTotal = 0

        for i in self.funcionarios:
            valorTotal += i.calculaSalario()

        print("Quantidade de funcionarios: ", self.qntdFuncionarios)
        print("Folha Salarial: R${:.2f}\n".format(valorTotal))

if __name__ == '__main__':
    opcao = 0
    folha = FolhaSalarial()

    # Enquanto o usuario nao quiser sair do programa...
    while (opcao != 5):
        # Lendo acao a ser realizada.
        opcao = FolhaSalarial.leOpcao()

        if (opcao == 1): # Adicionar Gerente
            # Lendo as informacoes do Gerente.
            print("Nome: ", end = "")
            nome = input()
            print("CPF: ", end = "")
            cpf = input()
            print("Salario Base: ", end = "")
            salarioBase = float(input())

            # Caso o CPF seja valido, adicionando o Gerente na folha salarial.
            if (Funcionario.verificaCPF(cpf)):
                gerente = Gerente(nome, cpf, salarioBase)
                folha.adicionaFuncionario(gerente)

                print(" ------- Funcionario Adicionado com sucesso -------\n")
            else:
                print(" ------- CPF invalido -------\n")
        elif (opcao == 2): # Adicionar Vendedor
            # Lendo as informacoes do Vendedor.
            print("Nome: ", end = "")
            nome = input()
            print("CPF: ", end = "")
            cpf = input()
            print("Salario Base: ", end = "")
            salarioBase = float(input())
            print("Comissao: ", end = "")
            comissao = float(input())

            # Caso o CPF seja valido, adicionando o Vendedor na folha salarial.
            if (Funcionario.verificaCPF(cpf)):
                vendedor = Vendedor(nome, cpf, salarioBase, comissao)
                folha.adicionaFuncionario(vendedor)

                print(" ------- Funcionario Adicionado com sucesso -------\n")
            else:
                print(" ------- CPF invalido -------\n")
        elif (opcao == 3): # Adicionar Assistente
            # Lendo as informacoes do Assistente.
            print("Nome: ", end = "")
            nome = input()
            print("CPF: ", end = "")
            cpf = input()
            print("Salario Base: ", end = "")
            salarioBase = float(input())

            # Caso o CPF seja valido, adicionando o Assistente na folha salarial.
            if (Funcionario.verificaCPF(cpf)):
                assistente = Assistente(nome, cpf, salarioBase)
                folha.adicionaFuncionario(assistente)

                print(" ------- Funcionario Adicionado com sucesso -------\n")
            else:
                print(" ------- CPF invalido -------\n")
        elif (opcao == 4):
            folha.geraFolhaSalarial()
        elif (opcao == 5):
            print(" ------- Saindo do programa -------\n");
        else:
            print(" ------- Opção invalida -------\n");