package veiculo;

public class Veiculo {

	private String nome;
	private String marca;
	private String motorizacao;
	private String cor;
	private int placa;
	private int renavam;
	// quantidade atual de combustível
	private double tanque;
	// constante
	private final double capacidade;

	public Veiculo(String nome, String marca, String motorizacao, String cor, int placa, int renavam,
			double capacidade) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.motorizacao = motorizacao;
		this.cor = cor;
		this.placa = placa;
		this.renavam = renavam;
		this.capacidade = capacidade;
	}

	public Veiculo(String nome) {
		super();
		capacidade = 30;
		this.nome = nome;
	}

	public Veiculo() {
		capacidade = 30;
	}

	@Override
	public String toString() {
		return "Veiculo [nome=" + nome + "]";
	}

}
