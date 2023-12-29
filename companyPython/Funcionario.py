from abc import ABC, abstractmethod
import re

class Funcionario(ABC):
    def __init__(self, nome, cpf, salarioBase):
        self.nome = nome
        self.cpf = cpf
        self.salarioBase = salarioBase

    @abstractmethod
    def calculaSalario():
        pass

    @staticmethod
    def verificaCPF(cpf):
        # Retirando caracteres nao numericos do CPF.
        cpf = re.sub('[^0-9]', "", cpf)

        if (len(cpf) != 11):
            return False

        # Pegando os 9 primeiros digitos do CPF.
        cpfBase = Funcionario.criaCpfBase(cpf)
        
        # Calculando o primeiro digito verificador e validando-o.
        digVerificador = Funcionario.calculaDigitoVerificador(cpfBase, 10)
        if (digVerificador != int(cpf[9])):
            return False
        
        # Caso o digito seja valido, adicionando-o ao CPF base.
        cpfBase.append(digVerificador)

        # Calculando o segundo digito verificador e validando-o.
        digVerificador = Funcionario.calculaDigitoVerificador(cpfBase, 11)
        if (digVerificador != int(cpf[10])):
            return False
        
        return True
    
    @staticmethod
    # Retorna os 9 primeiros valores de uma String de numeros.
    def criaCpfBase(cpf):
        cpfBase = []

        for i in range(9):
            cpfBase.append(int(cpf[i]))

        return cpfBase

    @staticmethod
    # Calcula os digitos verificadores de acordo com a especificacao do professor.
    def calculaDigitoVerificador(cpf, pesoInicial):
        soma = 0

        i = 0
        for j in range(pesoInicial, 1, -1):
            soma += (cpf[i] * j)
            i += 1

        digVerificador = (soma * 10) % 11
        if (digVerificador == 10 or digVerificador == 11):
            digVerificador = 0

        return digVerificador