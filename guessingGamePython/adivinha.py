class Adivinha(object):
    # Números mínimo e máximo do intervalo de números disponíveis para chute 
    min: int
    max: int
    # Número chutado pelo programa
    num_chute: int
    # Controla a execução do programa. Torna-se 'True' caso o programa acerte o número
    correto: bool

    def __init__(self):
        self.min = 0
        self.correto = False

    def pede_max(self):
        print("Digite o maior tamanho do intervalo: ")
        # Adicionando 1 ao número máximo para que o programa também consiga chutá-lo
        # Deve-se fazer isso devido ao casting realizado em 'chuta_num'
        self.max = int(input()) + 1

    def chuta_num(self):
        self.num_chute = int((self.max + self.min) / 2)
        
    def verifica_chute(self):
        resposta = input("\nO número que você pensou é maior, menor ou igual à {}?\n".format(self.num_chute))

        if(resposta == "maior"):
            self.min = self.num_chute
        elif(resposta == "menor"):
            self.max = self.num_chute
        elif(resposta == "igual"):
            self.correto = True
        else:
            print("Opção inválida")

    def jogar(self):
        self.pede_max()

        while(not self.correto):
            self.chuta_num()
            self.verifica_chute()

        print("\nAcertei :)")


if __name__ == '__main__':
    jogo_adivinha = Adivinha()

    jogo_adivinha.jogar()