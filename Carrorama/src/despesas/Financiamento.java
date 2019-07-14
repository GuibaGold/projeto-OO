package despesas;

import java.util.List;

import javax.swing.JOptionPane;

import excecoes.ValorInvalidoException;
import proprietario.Veiculo;

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
	
	public static void CadastrarFinanciamento(Financiamento financiamentoCadastro, Veiculo veiculo) throws ValorInvalidoException {
		if(ValidarFinanciamento(financiamentoCadastro)) {
			veiculo.despesasVeiculo.add(financiamentoCadastro);
			JOptionPane.showConfirmDialog(null, "Financiamento Cadastrado com Sucesso!", "Cadastro Financiamento", JOptionPane.PLAIN_MESSAGE);
		}else {
			throw new excecoes.ValorInvalidoException("Financiamento inválido.");
		}
	}
	
	private static boolean ValidarFinanciamento(Financiamento financiamentoCadastro) {
		if(financiamentoCadastro.getData().isBlank()) {
			return false;
		}else if(financiamentoCadastro.getNome().isBlank()) {
			return false;
		}else if(financiamentoCadastro.getQtdParcelas() == 0) {
			return false;
		}else if(financiamentoCadastro.getValor() == 0) {
			return false;
		}
		return true;
	}

	public int getQtdParcelas() {
		return qtdParcelas;
	}
	
	public double valorParcela() {
		return valorParcela;
	}
	
}
