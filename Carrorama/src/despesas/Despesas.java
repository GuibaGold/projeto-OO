package despesas;

public abstract class Despesas {
	
	private String nome;
	private String data;
	private double valor; 
	private int tipoDespesa; // 1 - Abastecimento, 2 - Manutencao, 3 - Outras taxas
	
	public Despesas(String nome, String data, double valor, int tipoDespesa) {
		this.nome = nome;
		this.data = data;
		this.valor = valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}
	
	public String getData() {
		return data;
	}
	
	public double getValor() {
		return valor;
	}
}
