package empresa;

public class Vendedor extends Funcionario{
	double comissao;
	
	public Vendedor (String nome, String cpf, double salario, double comissao) {
		super(nome, cpf, salario);
		this.comissao = comissao;
	}
	
	@Override
	protected double calculaSalario() {
		return this.salarioBase + this.comissao;
	}
}