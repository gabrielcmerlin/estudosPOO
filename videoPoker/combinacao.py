def verificar_dois_pares(jogador):
    jogador.ordenar_cartas_valor()

    qntd_pares = 0
    valor_carta_anterior = -1

    # Loop verifica se a carta atual tem o mesmo valor que a carta vista anteriormente, caso seja, temos um par
    for carta in jogador.cartas:
        if(carta.get_valor() == valor_carta_anterior):
            qntd_pares += 1

        valor_carta_anterior = carta.get_valor()

    if(qntd_pares == 2):
        return True
    
    return False

def verificar_trinca(jogador):
    jogador.ordenar_cartas_valor()

    cartas = jogador.get_cartas()

    # Estando a lista de cartas ordenada pelo valor, aquelas que tiverem o mesmo valor estarão juntas. Logo, as 3
    # possíveis cartas da trinca poderão estar em apenas 3 locais diferentes ([0 .. 2] ou [1 .. 3] ou [2 .. 4])
    if(cartas[0].get_valor() == cartas[2].get_valor() or cartas[1].get_valor() == cartas[3].get_valor() or cartas[2].get_valor() == cartas[4].get_valor()):
        return True

    return False

def verificar_straight(jogador):
    jogador.ordenar_cartas_valor()

    contador = 0
    valor_carta0 = jogador.cartas[0].get_valor()

    # Loop verifica se as cartas do jogador têm valores seguidos
    for carta in jogador.cartas:
        if(carta.get_valor() == (valor_carta0 + contador)):
            contador += 1

    if(contador == 5):
        return True
    
    return False

def verificar_flush(jogador):
    jogador.ordenar_cartas_naipe()

    cartas = jogador.get_cartas()

    # Estando a lista de cartas ordenada pelo naipe, se a primeira e a última carta tiverem o mesmo naipe, as
    # outras também terão 
    if(cartas[0].get_naipe() == cartas[4].get_naipe()):
        return True
    
    return False    

def verificar_full_hand(jogador):
    jogador.ordenar_cartas_valor()

    cartas = jogador.get_cartas()

    # A Condicional exterior verifica se há uma trinca. Já a interior verifica se as cartas que sobraram formam um par
    if(cartas[0].get_valor() == cartas[2].get_valor()):
        if(cartas[3].get_valor() == cartas[4].get_valor()):
            return True
    elif(cartas[2].get_valor() == cartas[4].get_valor()):
        if(cartas[0].get_valor() == cartas[1].get_valor()):
            return True
        
    return False

def verificar_quadra(jogador):
    jogador.ordenar_cartas_valor()

    cartas = jogador.get_cartas()

    # Estando a lista de cartas ordenada pelo valor, aquelas que tiverem o mesmo valor estarão juntas. Logo, as 4
    # possíveis cartas da quadra poderão estar em apenas 2 locais diferentes ([0 .. 3] ou [1 .. 4])
    if(cartas[0].get_valor() == cartas[3].get_valor() or cartas[1].get_valor() == cartas[4].get_valor()):
        return True
        
    return False

def verificar_s_flush(jogador):
    jogador.ordenar_cartas_valor()

    contador = 0
    valor_carta0 = jogador.cartas[0].get_valor()
    naipe_carta0 = jogador.cartas[0].get_naipe()

    # Loop verifica se as cartas do jogador têm valores seguidos e o mesmo naipe
    for carta in jogador.cartas:
        if(carta.get_valor() == (valor_carta0 + contador) and carta.get_naipe() == naipe_carta0):
            contador += 1

    if(contador == 5):
        return True
    
    return False

def verificar_rs_flush(jogador):
    jogador.ordenar_cartas_valor()

    contador = 0
    naipe_carta0 = jogador.cartas[0].get_naipe()

    # Loop verifica se as cartas do jogador têm valores seguidos (entre 10 e Às) e o mesmo naipe
    for carta in jogador.cartas:
        if(carta.get_valor() == (10 + contador) and carta.get_naipe() == naipe_carta0):
            contador += 1

    if(contador == 5):
        return True
    
    return False

# Verifica todas os tipos possíveis de combinação de cartas do Poker. As combinações com mais requisitos
# são verificadas primeiro a fim de evitar erros na pontuação
# Exemplo: um Royal Straight Flush sempre será um Straight Flush, mas o contrário não é verdade. Logo, se
# verificássemos o Straight Flush primeiro, nunca veríamos um Royal Straight Flush 
def verificar_combinacao(jogador):
    if(verificar_rs_flush(jogador)):
        multiplicador = 200
    elif(verificar_s_flush(jogador)):
        multiplicador = 100
    elif(verificar_quadra(jogador)):
        multiplicador = 50
    elif(verificar_full_hand(jogador)):
        multiplicador = 20
    elif(verificar_flush(jogador)):
        multiplicador = 10
    elif(verificar_straight(jogador)):
        multiplicador = 5
    elif(verificar_trinca(jogador)):
        multiplicador = 2
    elif(verificar_dois_pares(jogador)):
        multiplicador = 1
    else:
        multiplicador = 0

    return multiplicador