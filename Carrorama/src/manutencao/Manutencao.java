package manutencao;

public abstract class Manutencao {
	private String nome;
	private int quilomentra;
	private double valor;

	public Manutencao(String nome, int quilomentra, double valor) {
		super();
		this.nome = nome;
		this.quilomentra = quilomentra;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuilomentra() {
		return quilomentra;
	}

	public void setQuilomentra(int quilomentra) {
		this.quilomentra = quilomentra;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
