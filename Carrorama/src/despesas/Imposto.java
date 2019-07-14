package despesas;

import proprietario.Veiculo;

public class Imposto extends Despesas {
	
	private String tipoImposto; // 1 - DPVAT, 2 - IPVA, 3 - Licenciamento 
	private int qtdParcelas;
	private double valorParcela;
	
	public Imposto(String nome, String data, double valorParcela, int qtdParcelas, String tipoImposto) {
		
		super(nome, data, 0);
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

	@Override
	public String toString() {
		return "Imposto ["+ super.toString() + " tipoImposto = " + tipoImposto + ", qtdParcelas = " + qtdParcelas + ", valorParcela = " + valorParcela
				+ "]";
	}

	public static void CadastrarImposto(Imposto impostoCadastro, Veiculo veiculo) {
		if(ValidarImposto(impostoCadastro)) {
			veiculo.despesasVeiculo.add(impostoCadastro);
		}
		
	}

	private static boolean ValidarImposto(Imposto impostoCadastro) {
		if(impostoCadastro.getData().isBlank()) {
			return false;
		}else if(impostoCadastro.getNome().isBlank()) {
			return false;
		}else if(impostoCadastro.getQtdParcelas() == 0) {
			return false;
		}else if(impostoCadastro.getTipoImposto().isBlank()) {
			return false;
		}else if(impostoCadastro.getValor() == 0) {
			return false;
		}else if(impostoCadastro.getValorParcela() == 0) {
			return false;
		}
		return true;
	}
	
}
