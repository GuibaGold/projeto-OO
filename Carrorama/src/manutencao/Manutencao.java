package manutencao;

public abstract class Manutencao {
	private String nome;
	private int quilometragem;
	private double valor;

	public Manutencao(String nome, int quilometragem, double valor) {
		super();
		this.nome = nome;
		this.quilometragem = quilometragem;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuilomentra() {
		return quilometragem;
	}

	public void setQuilomentra(int quilometragem) {
		this.quilometragem = quilometragem;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
