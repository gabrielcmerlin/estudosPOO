# Gabriel da Costa Merlin - 12544420
# Mateus Bernal Leffeck - 13673318

from Carta import Carta
from random import shuffle

class Baralho(object):
    # Essa lista conterá todas as 52 cartas de um baralho
    baralho: list

    def __init__(self):
        self.baralho = []

        for i in range(2, 15):      # Itera sobre os valores
            for j in range(4):      # Itera sobre os naipes
                # Criando uma nova carta
                carta = Carta()
                carta.set_valor(i)
                carta.set_naipe(j)

                # Inserindo ela no baralho
                self.baralho.append(carta)
        
        self.embaralhar()
            
    def embaralhar(self):
        shuffle(self.baralho)

    def pegar_carta(self):
        # Pegando a carta do topo
        carta_recebida = self.baralho[0]

        self.embaralhar()

        return carta_recebida