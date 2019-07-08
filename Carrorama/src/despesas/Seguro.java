package despesas;

public class Seguro extends Despesas {
	
	private String nomeSeguradora;
	private int numeroApolice;
	
	public Seguro(String nome, String data, double valor, String nomeSeguradora, int numeroApolice) {
		super(nome, data, valor, 3);
		this.nomeSeguradora = nomeSeguradora;
		this.numeroApolice = numeroApolice;
	}
}
