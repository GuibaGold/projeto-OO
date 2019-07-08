package despesas;

public class Financiamento extends Despesas{

	private int qtdParcelas;
	private int parcelasPagas;
	private double jurosMensal;
	private double totalSemJuros;
	
	public Financiamento(String nome, String data, double valor, int qtdParcelas, int parcelasPagas, double jurosMensal, double totalSemJuros) {
		
		super(nome, data, valor);
		this.qtdParcelas = qtdParcelas;
		this.parcelasPagas = parcelasPagas;
		this.jurosMensal = jurosMensal;
		this.totalSemJuros = totalSemJuros;
	}

	public int getQtdParcelas() {
		return qtdParcelas;
	}

	public int getParcelasPagas() {
		return parcelasPagas;
	}

	public double getJurosMensal() {
		return jurosMensal;
	}

	public double getTotalSemJuros() {
		return totalSemJuros;
	}
}
