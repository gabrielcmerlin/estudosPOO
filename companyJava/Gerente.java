package empresa;

public class Gerente extends Funcionario {	
	public Gerente (String nome, String cpf, double salario) {
		super(nome, cpf, salario);
	}
	
	@Override
	protected double calculaSalario() {
		return 2 * this.salarioBase;
	}
}