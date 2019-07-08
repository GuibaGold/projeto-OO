package despesas;

public class Abastecimento extends Despesas {
	
	private int tpDeCombustivel;
	private int hodometro;
	private double valorDoLitro;
	private boolean tanqueCheio;

	public Abastecimento(String data, String nome, int tpDeCombustivel, int hodometro, double valorDoLitro, double valor,boolean tanqueCheio) {
		// TODO Auto-generated constructor stub
		super(nome,data,valor);
		this.tpDeCombustivel = tpDeCombustivel;
		this.hodometro = hodometro;
		this.valorDoLitro = valorDoLitro;
		this.tanqueCheio = tanqueCheio;
	}
	
	public int getTpDeCombustivel() {
		return tpDeCombustivel;
	}

	public int getHodometro() {
		return hodometro;
	}

	public double getValorDoLitro() {
		return valorDoLitro;
	}

	public boolean isTanqueCheio() {
		return tanqueCheio;
	}

}
