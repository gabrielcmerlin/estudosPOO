package com.mycompany.bozo;


/*
Feito pelos alunos:
Gabriel da Costa Merlin 12544420
Mateus Bernal Leffeck 13673318
*/
public class Placar {

    private int[][] placar;
    private boolean[] posicoesOcupadas;

    public Placar() {
        placar = new int[10][2];
        posicoesOcupadas = new boolean[10];
    }

    public void add(int posicao, int[] dados) throws IllegalArgumentException {
        if (posicao < 1 || posicao > 10) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicoesOcupadas[posicao - 1]) {
            throw new IllegalArgumentException("Posição já ocupada");
        }

        placar[posicao - 1][0] = calcularPontuacao(posicao, dados);
        placar[posicao - 1][1] = posicao;
        posicoesOcupadas[posicao - 1] = true;
    }

    private int calcularPontuacao(int posicao, int[] dados) {
        int pontuacao = 0;

        if (posicao >= 1 && posicao <= 6) {
            int valorDado = posicao;
            for (int dado : dados) {
                if (dado == valorDado) {
                    pontuacao += valorDado;
                }
            }
        } else if (posicao == 7) {
            boolean temPar = false;
            boolean temTrio = false;

            for (int i = 1; i <= 6; i++) {
                int count = 0;
                for (int dado : dados) {
                    if (dado == i) {
                        count++;
                    }
                }

                if (count == 2) {
                    temPar = true;
                } else if (count == 3) {
                    temTrio = true;
                }
            }

            if (temPar && temTrio) {
                pontuacao = 15;
            }
        } else if (posicao == 8) {
            int[] contagem = new int[6];

            for (int dado : dados) {
                contagem[dado - 1]++;
            }

            for (int i = 0; i < 6; i++) {
                if (contagem[i] >= 1 && contagem[i + 1] >= 1 && contagem[i + 2] >= 1 && contagem[i + 3] >= 1 && contagem[i + 4] >= 1) {
                    pontuacao = 20;
                    break;
                }
            }
        } else if (posicao == 9) {
            for (int i = 1; i <= 6; i++) {
                int count = 0;
                for (int dado : dados) {
                    if (dado == i) {
                        count++;
                    }
                }

                if (count >= 4) {
                    pontuacao = somarValores(dados);
                    break;
                }
            }
        } else if (posicao == 10) {
            for (int i = 1; i <= 6; i++) {
                int count = 0;
                for (int dado : dados) {
                    if (dado == i) {
                        count++;
                    }
                }

                if (count == 5) {
                    pontuacao = 50;
                    break;
                }
            }
        }

        return pontuacao;
    }

    private int somarValores(int[] dados) {
        int soma = 0;
        for (int dado : dados) {
            soma += dado;
        }
        return soma;
    }

    public int getScore() {
        int soma = 0;
        for (int i = 0; i < 10; i++) {
            if (posicoesOcupadas[i]) {
                soma += placar[i][0];
            }
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" " + (posicoesOcupadas[0] ? placar[0][0] : "(1)") + "    |   " + (posicoesOcupadas[6] ? placar[6][0] : "(7)") + "    |   " + (posicoesOcupadas[3] ? placar[3][0] : "(4)") + " \n");
        sb.append("--------------------------\n");
        sb.append(" " + (posicoesOcupadas[1] ? placar[1][0] : "(2)") + "    |   " + (posicoesOcupadas[7] ? placar[7][0] : "(8)") + "     |   " + (posicoesOcupadas[4] ? placar[4][0] : "(5)") + " \n");
        sb.append("--------------------------\n");
        sb.append(" " + (posicoesOcupadas[2] ? placar[2][0] : "(3)") + "    |   " + (posicoesOcupadas[8] ? placar[8][0] : "(9)") + "     |   " + (posicoesOcupadas[5] ? placar[5][0] : "(6)") + " \n");
        sb.append("--------------------------\n");
        sb.append("        |   " + (posicoesOcupadas[9] ? placar[9][0] : "(10)") + "   |\n");
        sb.append("        +----------+ \n");

        return sb.toString();
    }

}
