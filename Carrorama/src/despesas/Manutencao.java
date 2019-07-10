package despesas;

public class Manutencao extends Despesas {

	private double quilometragem;
	private double validade;

	public Manutencao(String nome, String data, double valor, double quilometragem, double validade) {
		super(nome, data, valor);
		this.quilometragem = quilometragem;
		this.validade = validade;
	}

	public double getValidade() {
		return validade;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	@Override
	public String toString() {
		return "Manutencao ["+ super.toString() + " quilometragem = " + quilometragem + ", validade = " + validade + "]";
	}
	
}
