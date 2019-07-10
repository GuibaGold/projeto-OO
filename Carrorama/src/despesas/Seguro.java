package despesas;

public class Seguro extends Despesas {
	
	private String nomeSeguradora;
	private String numeroApolice;
	
	public Seguro() {
		
	}
	public Seguro(String nome, String data, double valor, String nomeSeguradora, String numeroApolice) {
		super(nome, data, valor, 3);
		this.nomeSeguradora = nomeSeguradora;
		this.numeroApolice = numeroApolice;
	}
}
