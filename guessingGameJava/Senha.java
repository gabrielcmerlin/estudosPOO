import java.util.Scanner;

public class Senha {
    private int max;				// Maior valor que o programa pode criar um número aleatório
	private int num_aleatorio;		// Armazena o valor aleatorizado pelo programa
	private int acertou;			// 0 = usuário jogando | 1 = usuário acertou
	private int num_chute;			// Armazena o valor chutado pelo usuário
	private int tentativas = 0;		// Armazena a quantidade de chutes que o usuário deu até acertar o valor aleatorizado

	Scanner ler = new Scanner(System.in);
    
	// Inicializa o atributo "max" com o numero inteiro que o usuário digitou
    private void pede_max() {
		System.out.println("Digite o maior tamanho do intervalo: ");
		this.max = ler.nextInt();
	}

	/*
		Usa a classe "Random" para aleatorizar um número inteiro entre 0 e "max". Após
		isso, usa esse valor para inicializar "num_aleatorio"
	*/
    private void gera_aleatorio() {
        Random r = new Random();
		this.num_aleatorio = r.getIntRand(this.max) + 1;
    }

	// Lê o valor chutado pelo usuário e atualiza o valor de "num_chute"
    private void ler_chute() {
		System.out.println("\nDigite um número: ");
		this.num_chute = ler.nextInt();
	}

	// Verifica se o chute do usuário é menor, maior ou igual ao valor aleatorizado pelo programa
	private void verifica_chute() {
		if(this.num_aleatorio == this.num_chute) {
			acertou = 1;
			System.out.println("\nVocê acertou :)");
		} else if(this.num_aleatorio < this.num_chute) {
			System.out.println("O número procurado é MENOR que " + this.num_chute);
		} else {
			System.out.println("O número procurado é MAIOR que " + this.num_chute);
		}
	}

	// Implementa o Jogo da Senha
    public void jogar() {
        this.pede_max();
	    
        this.gera_aleatorio();

		System.out.println("\nAgora encontre um valor entre 0 e " + this.max);
		
		while(this.acertou == 0) {
			this.tentativas++;

			this.ler_chute();
            this.verifica_chute();
		}

		System.out.println("Para acertar você levou " + this.tentativas + " tentativas\n");
    }

	public static void main(String[] args) {
		Senha jogo_senha = new Senha();

        jogo_senha.jogar();
	}
}