package despesas;

public class Financiamento extends Despesas{

	private int qtdParcelas;
	private double valorParcela;
	
	public Financiamento(String nome, String data, double valorParcela, int qtdParcelas) {
		super(nome, data, 0);
		this.valorParcela = valorParcela;
		this.qtdParcelas = qtdParcelas;
		double valor = qtdParcelas * valorParcela;
		this.setValor(valor); // valor total do financiamento
	}

	public int getQtdParcelas() {
		return qtdParcelas;
	}
	
	public double valorParcela() {
		return valorParcela;
	}
	
}
