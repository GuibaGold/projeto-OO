package despesas;

import java.util.List;

import javax.swing.JOptionPane;

import excecoes.CombustivelIncompativelException;
import excecoes.ValorInvalidoException;
import proprietario.Veiculo;
import util.util;

public class Abastecimento extends Despesas {
	
	private String tpDeCombustivel;
	private int quilometragem;
	private double valorDoLitro;
	private boolean tanqueCheio;
	private String quantidade;
	

	public Abastecimento(String data, String nome, String tpDeCombustivel, int quilometragem, double valorDoLitro, double valor,boolean tanqueCheio, String quantidade) {

		super(nome, data, valor);
		this.tpDeCombustivel = tpDeCombustivel;
		this.quilometragem = quilometragem;
		this.valorDoLitro = valorDoLitro;
		this.tanqueCheio = tanqueCheio;
		this.quantidade = quantidade;
	}
	
	public static void CadastrarAbastecimento(Abastecimento abastecimentoCadastro, Veiculo veiculo) throws CombustivelIncompativelException, ValorInvalidoException {
			if(util.getDoubleValue(abastecimentoCadastro.quantidade) <= util.getDoubleValue(veiculo.getCapacidade()) 
					&& ValidarCadastroAbastecimento(veiculo, abastecimentoCadastro.tpDeCombustivel, util.getDoubleValue(abastecimentoCadastro.quantidade))) {
				veiculo.despesasVeiculo.add(abastecimentoCadastro);
				JOptionPane.showConfirmDialog(null, "Abastecimento Cadastrado com Sucesso!", "Cadastro Abastecimento", JOptionPane.PLAIN_MESSAGE);
		}else {
			throw new excecoes.ValorInvalidoException("Não foi possível Cadastrar Abastecimento.");
		}
			
	}
	
	public static boolean ValidarCadastroAbastecimento(Veiculo veiculo, String tipoCombustivel, double quantidadeAbastecida) {
		if(veiculo.getAnoDeFabricacao() > 2019) {
			return false;
		}else if(veiculo.getAnoDoModelo() > 2019) {
			return false;
		}else if(Integer.parseInt(veiculo.getCapacidade()) < 1) {
			return false;
		}else if(Double.parseDouble(veiculo.getCapacidade()) < quantidadeAbastecida) {
			return false;
		}
		
		return true;
	}
	
	public String getTpDeCombustivel() {
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

	@Override
	public String toString() {
		return "Abastecimento ["+ super.toString() +", tpDeCombustivel = " + tpDeCombustivel + ", quilometragem = " + quilometragem
				+ ", valorDoLitro = " + valorDoLitro + ", tanqueCheio = " + tanqueCheio + "]";
	}


}
