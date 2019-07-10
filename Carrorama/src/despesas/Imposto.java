package despesas;

public class Imposto extends Despesas {
	
	private String tipoImposto; // 1 - DPVAT, 2 - IPVA, 3 - Licenciamento 
	private int qtdParcelas;
	private double valorParcela;
	
	public Imposto(String nome, String data, double valorParcela, int qtdParcelas, String tipoImposto) {
		
		super(nome, data, 0, 3);
		this.valorParcela = valorParcela;
		this.qtdParcelas = qtdParcelas;
		this.tipoImposto = tipoImposto;
		double valor = qtdParcelas * valorParcela;
		this.setValor(valor); // valor total do imposto		
	}
	
	public Imposto() {
		
	}

	public String getTipoImposto() {
		return tipoImposto;
	}

	public int getQtdParcelas() {
		return qtdParcelas;
	}

	public double getValorParcela() {
		return valorParcela;
	}
}
