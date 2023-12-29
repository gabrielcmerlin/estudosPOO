package empresa;

public class Assistente extends Funcionario {
	public Assistente (String nome, String cpf, double salario) {
		super(nome, cpf, salario);
	}
	
	@Override
	protected double calculaSalario() {
		return this.salarioBase;
	}
}