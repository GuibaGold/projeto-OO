package despesas;

public class Abastecimento extends Despesas {
	
	private int tpDeCombustivel;
	private int hodometro;
	private int litrosAbastecidos;
	private double valorDoLitro;
	private boolean tanqueCheio;

	public Abastecimento(String data, String nome, int tpDeCombustivel, int hodometro, double valorDoLitro, double valor,boolean tanqueCheio) {

		super(nome, data, valor, 1);
		this.tpDeCombustivel = tpDeCombustivel;
		this.hodometro = hodometro;
		this.valorDoLitro = valorDoLitro;
		this.tanqueCheio = tanqueCheio;
		this.litrosAbastecidos = (int) (this.getValor() / valorDoLitro);
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
