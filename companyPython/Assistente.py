from Funcionario import Funcionario

class Assistente(Funcionario):
    def __init__(self, nome, cpf, salarioBase):
        super().__init__(nome, cpf, salarioBase)

    def calculaSalario(self):
        return self.salarioBase