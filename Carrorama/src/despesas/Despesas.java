package despesas;

public abstract class Despesas {
	
	private String nome;
	private String data;
	private double valor; 
	
	public Despesas(String nome, String data, double valor) {
		this.nome = nome;
		this.data = data;
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
