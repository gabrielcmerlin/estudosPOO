
/*
Feito pelos alunos:
Gabriel da Costa Merlin 12544420
Mateus Bernal Leffeck 13673318
 */
package com.mycompany.bozo;

/**
 *
 * @author mateu
 */
public class RolaDados {

    private Dado[] dados;

    public RolaDados(int n) {
        dados = new Dado[n];

        for (int i = 0; i < n; i++) {
            dados[i] = new Dado(6);
        }
    }

    public int[] rolar() {
        int[] valores = new int[dados.length];

        for (int i = 0; i < dados.length; i++) {
            valores[i] = dados[i].rolar();
        }

        return valores;
    }

    public int[] rolar(boolean[] quais) {
        int[] valores = new int[dados.length];

        for (int i = 0; i < dados.length; i++) {
            if (quais[i]) {
                valores[i] = dados[i].rolar();
            } else {
                valores[i] = dados[i].getLado();
            }
        }

        return valores;
    }

    public int[] rolar(String s) {
        String[] numeros = s.split(" ");
        int[] valores = new int[dados.length];

        for (String numero : numeros) {
            int posicao = Integer.parseInt(numero) - 1;

            if (posicao >= 0 && posicao < dados.length) {
                valores[posicao] = dados[posicao].rolar();
            }
        }

        return valores;
    }

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int linha = 0; linha < 5; linha++) {
        for (Dado dado : dados) {
            sb.append(dado.toString().split("\n")[linha]).append("  ");
        }
        sb.append("\n");
    }

    return sb.toString();
}

}
