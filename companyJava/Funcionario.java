package empresa;

public abstract class Funcionario {
	String nome;
	String CPF;
	double salarioBase;
	
	public Funcionario(String nome, String cpf, double salario) {
		this.nome = nome;
		this.CPF = cpf;
		this.salarioBase = salario;
	}
	
	protected abstract double calculaSalario();
	
	public static boolean verificaCPF(String cpf) {
		// Retirando caracteres nao numericos do CPF.
		cpf = cpf.replaceAll("[^0-9]", "");
		
		if (cpf.length() != 11) return false;
		
		// Pegando os 9 primeiros digitos do CPF.
		int cpfBase[] = criaCpfBase(cpf);
		
		// Calculando o primeiro digito verificador e vendo, a partir dele, se o CPF eh valido.
		int digVerificador = calculaDigitoVerificador(cpfBase, 10);
		if (digVerificador != Character.getNumericValue(cpf.charAt(9))) return false;
		// Caso o CPF seja valido, adiciono o primeiro digito verificador ao CPF.
		cpfBase[9] = digVerificador;
		
		// Calculando o segundo digito verificador e vendo, a partir dele, se o CPF eh valido.
		digVerificador = calculaDigitoVerificador(cpfBase, 11);
		if (digVerificador != Character.getNumericValue(cpf.charAt(10))) return false;
		
		return true;
	}
	
	// Retorna os 9 primeiros valores de uma String de numeros.
	private static int[] criaCpfBase(String cpf) {
		int cpfBase[] = new int[10];

		for (int i = 0; i < 9; i++) {
			cpfBase[i] = Character.getNumericValue(cpf.charAt(i));
		}
		
		return cpfBase;
	}
	
	// Calcula os digitos verificadores de acordo com a especificacao do professor.
	private static int calculaDigitoVerificador(int cpfBase[], int pesoInicial) {
		int soma = 0;
		
		for (int i = 0; (pesoInicial - i) >= 2; i++) {
			soma += cpfBase[i] * (pesoInicial - i);
		}

		int digVerificador = (soma * 10) % 11;
		if (digVerificador == 10 || digVerificador == 11) {
			digVerificador = 0;
		}
		
		return digVerificador;
	}
}