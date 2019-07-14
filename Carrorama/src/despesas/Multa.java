package despesas;

import javax.swing.JOptionPane;

import excecoes.DescriçãoEmBrancoException;
import proprietario.Veiculo;

public class Multa extends Despesas {

	public Multa(String nome, String data, double valor) {
		super(nome, data, valor);
	}

	public static void CadastrarMulta(Multa multaCadastro, Veiculo veiculo) throws DescriçãoEmBrancoException {
		if(ValidarMulta(multaCadastro)) {
			veiculo.despesasVeiculo.add(multaCadastro);
			JOptionPane.showConfirmDialog(null, "Multa Cadastrada com Sucesso!", "Cadastro Multa", JOptionPane.PLAIN_MESSAGE);
		}else {
			throw new excecoes.DescriçãoEmBrancoException("Multa inválida, verifique se há campos em branco");
		}
	}

	private static boolean ValidarMulta(Multa multaCadastro) {
		if(multaCadastro.getData().isBlank()) {
			return false;
		}else if(multaCadastro.getNome().isBlank()){
			return false;
		}else if(multaCadastro.getValor() == 0) {
			return false;
		}
		return true;
	}
}
