package com.mycompany.bozo;


/*
Feito pelos alunos:
Gabriel da Costa Merlin 12544420
Mateus Bernal Leffeck 13673318
 */

public class Dado {

    private int valor;
    public int lados;
    private static Random random = new Random();

    // Construtores
    // Setar 6 lados
    public Dado() {
        this.lados = 6;
    }

    // n lados
    public Dado(int n) {
        this.lados = n;
    }

    public int rolar() {
        this.valor = random.getIntRand(this.lados) + 1;
        // Retornar o valor
        return this.valor;
    }

    public int getLado() {
        return this.valor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+-----+\n");

        switch (valor) {
            case 1 -> {
                sb.append("|     |\n");
                sb.append("|  *  |\n");
                sb.append("|     |\n");
            }
            case 2 -> {
                sb.append("|*    |\n");
                sb.append("|     |\n");
                sb.append("|    *|\n");
            }
            case 3 -> {
                sb.append("|*    |\n");
                sb.append("|  *  |\n");
                sb.append("|    *|\n");
            }
            case 4 -> {
                sb.append("|*   *|\n");
                sb.append("|     |\n");
                sb.append("|*   *|\n");
            }
            case 5 -> {
                sb.append("|*   *|\n");
                sb.append("|  *  |\n");
                sb.append("|*   *|\n");
            }
            case 6 -> {
                sb.append("|*   *|\n");
                sb.append("|*   *|\n");
                sb.append("|*   *|\n");
            }
        }

        sb.append("+-----+\n");
        return sb.toString();
    }
}
