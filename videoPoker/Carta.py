# Gabriel da Costa Merlin - 12544420
# Mateus Bernal Leffeck - 13673318

class Carta(object):
    # Cartas de 2 à 10 recebem seu valor
    # J  = 11
    # Q  = 12
    # K  = 13
    # Às = 14
    valor: int
    # Copas     = 0
    # Ouros     = 1
    # Paus      = 2
    # Espadas   = 3
    naipe: int

    def __init__(self):
        # Inicializando os campos da carta como nulos (-1)
        self.valor = -1
        self.naipe = -1

    def set_valor(self, valor):
        self.valor = valor
    
    def set_naipe(self, naipe):
        self.naipe = naipe

    def get_valor(self):
        return self.valor

    def get_naipe(self):
        return self.naipe
    
    def imprimir_valor_naipe(self):
        valor = self.get_valor()
        if(valor == 14):
            print("A ", end = "")
        elif(valor == 13):
            print("K ", end = "")
        elif(valor == 12):
            print("Q ", end = "")
        elif(valor == 11):
            print("J ", end = "")
        elif(valor == 10):
            print("10", end = "")
        else:
            print("{} ".format(valor), end = "")

        naipe = self.get_naipe()
        if(naipe == 0):
            print("\u2665", end = "")
        elif(naipe == 1):
            print("\u2666", end = "")
        elif(naipe == 2):
            print("\u2663", end = "")
        else:
            print("\u2660", end = "")