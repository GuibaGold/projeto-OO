package manutencao;

public abstract class Manutencao {
	
	private String nomeDespesa;
	private double quilometragem;
	private double valorDespesa;

	public Manutencao(String nomeDespesa, double quilometragem, double valorDespesa) {
		super();
		this.nomeDespesa = nomeDespesa;
		this.quilometragem = quilometragem;
		this.valorDespesa = valorDespesa;
	}

	public String getNomeDespesa() {
		return nomeDespesa;
	}

	public int getQuilometragem() {
		return quilometragem;
	}

	public double getValorDespesa() {
		return valorDespesa;
	}
}
