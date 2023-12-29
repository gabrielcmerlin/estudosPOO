
/*
Feito pelos alunos:
Gabriel da Costa Merlin 12544420
Mateus Bernal Leffeck 13673318
*/
package com.mycompany.bozo;

import java.io.IOException;

/**
 *
 * @author mateu
 */
public class Bozo {

    public static void main(String[] args) throws IOException {
        RolaDados dados = new RolaDados(5);
        Placar placar = new Placar();

        for (int rodada = 1; rodada <= 10; rodada++) {
            System.out.println("Rodada " + rodada + ":");
            // Rolar os dados para a rodada final
            int[] valoresDados = dados.rolar();

            // Duas rodadas de troca
            for (int rodadaTroca = 1; rodadaTroca <= 2; rodadaTroca++) {
                System.out.println("Rodada de Troca " + rodadaTroca + ":");

                // Rolar os dados
                boolean[] trocarDados = new boolean[5];
                for (int i = 0; i < 5; i++) {
                    trocarDados[i] = false;
                }

                System.out.println("Dados:");
                System.out.println(dados.toString());

                // Receber os dados que vão mudar
                System.out.println("Informe os números dos dados que deseja mudar (separados por espaços), ou 0 para não mudar nenhum:");
                String entrada = EntradaTeclado.leString();
                String[] numerosStr = entrada.split(" ");
                for (String numeroStr : numerosStr) {
                    int numero = Integer.parseInt(numeroStr);
                    if (numero != 0) {
                        trocarDados[numero - 1] = true;
                    }
                }

                // Rolar apenas os dados selecionados
                valoresDados = dados.rolar(trocarDados);

                System.out.println("--------------------------------------");
            }
            System.out.println(dados.toString());

            // Solicitar ao jogador a posição a ser preenchida
            System.out.println("Informe a posição a ser preenchida:");
            System.out.println(placar);
            String entrada = EntradaTeclado.leString();
            String[] posicoesStr = entrada.split(" ");
            int[] posicoes = new int[posicoesStr.length];
            for (int i = 0; i < posicoesStr.length; i++) {
                posicoes[i] = Integer.parseInt(posicoesStr[i]);
            }

            // Preencher as posições no placar
            try {
                for (int posicao : posicoes) {
                    placar.add(posicao, valoresDados);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }

            // Exibir o placar atualizado
            System.out.println("Placar:");
            System.out.println(placar);

            System.out.println("--------------------------------------");
        }

        // Exibir a pontuação final
        int pontuacaoFinal = placar.getScore();
        System.out.println("Pontuação final: " + pontuacaoFinal);
    }

}
