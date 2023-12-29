# Gabriel da Costa Merlin - 12544420
# Mateus Bernal Leffeck - 13673318

import os, combinacao
from Baralho import Baralho
from Jogador import Jogador
        
class Poker(object):
    baralho: Baralho
    jogador: Jogador
    aposta: int
    multiplicador: int

    def __init__(self):
        self.baralho = Baralho()
        self.jogador = Jogador()
        self.aposta = 0
        self.multiplicador = 0

    # Retorna False caso a aposta feita tenha valor negativo ou maior que o saldo do jogador. Caso contrário, retorna True
    def valor_aposta_valido(self, aposta):
        if(aposta > self.jogador.get_saldo() or aposta < 0):
            return False
        else:
            return True

    def pedir_valor_apostado(self):
        print("Saldo atual: ${}".format(self.jogador.get_saldo()))
        print("Digite o valor da aposta ou \"F\" para encerrar o jogo: ", end = "")
        resposta = input()

        # Caso o valor da aposta seja invalido, faz uma chamada recursiva
        if(resposta != "F" and not self.valor_aposta_valido(int(resposta))):
            print("\nValor apostado é invalido.\n")
            resposta = self.pedir_valor_apostado()
        
        return resposta
    
    def troca_de_cartas(self):
        self.jogador.imprimir_cartas()

        for i in range(2):
                print("Digite o número das cartas que você deseja trocar, separados por espaços: ", end = "")
                cartas_trocadas = input()
                cartas_trocadas = cartas_trocadas.split(" ")
                if(cartas_trocadas[0] != ""):
                    cartas_trocadas = list(map(int, cartas_trocadas))
                    self.jogador.atualizar_cartas(self.baralho, cartas_trocadas)

                self.jogador.imprimir_cartas()

    def imprimir_resultado_rodada(self):
        if(self.multiplicador == 0):
                print("\nVocê perdeu nessa rodada.")
        else:
            print("\nVocê ganhou R${} nessa rodada.".format(self.aposta * self.multiplicador))

    def imprimir_resultado_fim(self):
        print("\nJogo finalizado. ", end = "")
        if(self.jogador.get_saldo() > 0):
            print("Você ainda tem R${} de saldo.".format(self.jogador.get_saldo()))
        else:
            print("Você perdeu todo seu saldo.")

    def jogar(self):
        resposta = self.pedir_valor_apostado()

        while(resposta != "F"):
            self.aposta = int(resposta)

            # Debitando o valor da aposta do saldo do jogador e dando a ele 5 novas cartas
            self.jogador.set_saldo(self.jogador.get_saldo() - self.aposta)
            self.jogador.set_cartas(self.baralho)

            # Fazendo as trocas de cartas, caso o jogador queira
            self.troca_de_cartas()

            # Analisando as cartas do jogador e calcula qual o multiplicador de sua aposta
            self.multiplicador = combinacao.verificar_combinacao(self.jogador)

            self.imprimir_resultado_rodada()

            # Atualizando o saldo do jogador
            self.jogador.set_saldo(self.jogador.get_saldo() + (self.multiplicador * self.aposta))      

            # Caso o jogador perdeu todo seu dinheiro, encerramos o jogo
            if(self.jogador.get_saldo() <= 0):
                break
            
            print("Aperte ENTER para continuar.")
            input()
            os.system('clear')

            resposta = self.pedir_valor_apostado()

        self.imprimir_resultado_fim()

if __name__ == '__main__':
    jogo_poker = Poker()

    jogo_poker.jogar()