from Funcionario import Funcionario

class Gerente(Funcionario):
    def __init__(self, nome, cpf, salarioBase):
        super().__init__(nome, cpf, salarioBase)

    def calculaSalario(self):
        return 2 * self.salarioBase