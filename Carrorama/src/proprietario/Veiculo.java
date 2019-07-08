package proprietario;

public class Veiculo {

	private String marca;
	private String cor;
	private String modelo;
	private int anoDeFabricacao;
	private int anoDoModelo;
	private int placa;
	private int capacidade;
	private int renavam;
	private int tipoDeCombustivel;
	private int combustivelAtual;
	private double motorizacao;

	public Veiculo(String marca, String cor, String modelo, int anoDeFabricacao, int anoDoModelo, int placa, int capacidade, int renavam, int tipoDeCombustivel, int combustivelAtual, double motorizacao) {
		
		this.marca = marca;
		this.cor = cor;
		this.modelo = modelo;
		this.anoDeFabricacao = anoDeFabricacao;
		this.anoDoModelo = anoDoModelo;
		this.placa = placa;
		this.capacidade = capacidade;
		this.renavam = renavam;
		this.tipoDeCombustivel = tipoDeCombustivel;
		this.combustivelAtual = combustivelAtual;		
		this.motorizacao = motorizacao;
	}

	public String getMarca() {
		return marca;
	}

	public String getCor() {
		return cor;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAnoDeFabricacao() {
		return anoDeFabricacao;
	}

	public int getAnoDoModelo() {
		return anoDoModelo;
	}

	public int getPlaca() {
		return placa;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public int getRenavam() {
		return renavam;
	}

	public int getTipoDeCombutivel() {
		return tipoDeCombustivel;
	}

	public int getCombustivelAtual() {
		return combustivelAtual;
	}

	public double getMotorizacao() {
		return motorizacao;
	}

}
