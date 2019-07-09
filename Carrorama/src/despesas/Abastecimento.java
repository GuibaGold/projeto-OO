package despesas;

public class Abastecimento extends Despesas {
	
	private int tpDeCombustivel;
	private int quilometragem;
	private double valorDoLitro;
	private boolean tanqueCheio;

	public Abastecimento(String data, String nome, int tpDeCombustivel, int quilometragem, double valorDoLitro, double valor,boolean tanqueCheio) {

		super(nome, data, valor, 1);
		this.tpDeCombustivel = tpDeCombustivel;
		this.quilometragem = quilometragem;
		this.valorDoLitro = valorDoLitro;
		this.tanqueCheio = tanqueCheio;
	}
	
	public int getTpDeCombustivel() {
		return tpDeCombustivel;
	}

	public int getquilometragem() {
		return quilometragem;
	}

	public double getValorDoLitro() {
		return valorDoLitro;
	}

	public boolean isTanqueCheio() {
		return tanqueCheio;
	}

}
