package despesas;

import javax.swing.JOptionPane;

import excecoes.ValorInvalidoException;
import proprietario.Veiculo;

public class Manutencao extends Despesas {

	private double quilometragem;
	private double validade;

	public Manutencao(String nome, String data, double valor, double quilometragem, double validade) {
		super(nome, data, valor);
		this.quilometragem = quilometragem;
		this.validade = validade;
	}
	
	public static void CadastrarManutencao(Manutencao manutencaoCadastro ,Veiculo veiculo) throws ValorInvalidoException {
		if(ValidarManutencao(manutencaoCadastro)) {
			veiculo.despesasVeiculo.add(manutencaoCadastro);
			JOptionPane.showConfirmDialog(null, "Manutenção Cadastrada com Sucesso!", "Cadastro Abastecimento", JOptionPane.PLAIN_MESSAGE);
		}else {
			throw new excecoes.ValorInvalidoException("Manutenção inválida!");
		}
		
	}

	private static boolean ValidarManutencao(Manutencao manutencaoCadastro) {
		if(manutencaoCadastro.getData().isBlank()) {
			return false;
		}else if(manutencaoCadastro.getNome().isBlank()) {
			return false;
		}else if(manutencaoCadastro.getQuilometragem() == 0) {
			return false;
		}else if(manutencaoCadastro.getValidade() == 0) {
			return false;
		}else if(manutencaoCadastro.getValor() == 0) {
			return false;
		}
		return false;
	}

	public double getValidade() {
		return validade;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	@Override
	public String toString() {
		return "Manutencao ["+ super.toString() + " quilometragem = " + quilometragem + ", validade = " + validade + "]";
	}
	
}
