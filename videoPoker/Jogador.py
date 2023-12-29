# Gabriel da Costa Merlin - 12544420
# Mateus Bernal Leffeck - 13673318

class Jogador(object):
    saldo: int
    cartas: list

    def __init__(self):
        self.saldo = 200
        self.cartas = []

    def set_saldo(self, saldo_novo):
        self.saldo = saldo_novo

    def get_saldo(self):
        return self.saldo
    
    def set_cartas(self, baralho):
        self.cartas.clear()

        # Pegando 5 cartas do baralho
        for i in range(5):
            # Loop evita que o jogador pegue uma carta que já possua
            carta_nova = baralho.pegar_carta()
            while(carta_nova in self.cartas):
                carta_nova = baralho.pegar_carta()

            self.cartas.append(carta_nova)

    def atualizar_cartas(self, baralho, cartas_atualizadas):
        # Atualizando apenas as cartas necessarias
        for i in cartas_atualizadas:
            # Loop evita que o jogador pegue uma carta que já possua
            carta_nova = baralho.pegar_carta()
            while(carta_nova in self.cartas):
                carta_nova = baralho.pegar_carta()

            self.cartas[i - 1] = carta_nova

    def get_cartas(self):
        return self.cartas

    # Ordena as cartas do jogador com base no valor das cartas
    def ordenar_cartas_valor(self):
        self.cartas.sort(key=lambda x: x.valor)

    # Ordena as cartas do jogador com base no naipe das cartas
    def ordenar_cartas_naipe(self):
        self.cartas.sort(key=lambda x: x.naipe)

    def imprimir_cartas(self):
        print("\n+-----+ +-----+ +-----+ +-----+ +-----+")
        print("|     | |     | |     | |     | |     |")
        for carta in self.cartas:
            print("| ", end = "")
            carta.imprimir_valor_naipe()
            print(" | ", end = "")
        print("\n|     | |     | |     | |     | |     |")
        print("+-----+ +-----+ +-----+ +-----+ +-----+")
        print("  (1)     (2)     (3)     (4)     (5)  ")