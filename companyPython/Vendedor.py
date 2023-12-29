from Funcionario import Funcionario

class Vendedor(Funcionario):
    def __init__(self, nome, cpf, salarioBase, comissao):
        super().__init__(nome, cpf, salarioBase)
        self.comissao = comissao

    def calculaSalario(self):
        return self.salarioBase + self.comissao