package despesas;

import javax.swing.JOptionPane;

import excecoes.DescriçãoEmBrancoException;
import proprietario.Veiculo;

public class Seguro extends Despesas {
	
	private String nomeSeguradora;
	private String numeroApolice;
	
	public Seguro() {
		
	}
	public Seguro(String nome, String data, double valor, String nomeSeguradora, String numeroApolice) {
		super(nome, data, valor);
		this.nomeSeguradora = nomeSeguradora;
		this.numeroApolice = numeroApolice;
	}
	
	public static void CadastrarSeguro(Seguro seguroCadastro, Veiculo veiculo) throws DescriçãoEmBrancoException {
		if(ValidarSeguro(seguroCadastro)) {
			veiculo.despesasVeiculo.add(seguroCadastro);
			JOptionPane.showConfirmDialog(null, "Seguro Cadastrado com Sucesso!", "Cadastro Seguro", JOptionPane.PLAIN_MESSAGE);
		}else {
			throw new excecoes.DescriçãoEmBrancoException("Seguro inválido, verifique se existe campos em branco.");
		}
	}
	
	private static boolean ValidarSeguro(Seguro seguroCadastro) {
		if(seguroCadastro.getData().isBlank()) {
			return false;
		}else if(seguroCadastro.getNome().isBlank()) {
			return false;
		}else if(seguroCadastro.getValor() == 0) {
			return false;
		}else if(seguroCadastro.getNomeSeguradora().isBlank()) {
			return false;
		}else if(seguroCadastro.getNumeroApolice().isBlank()) {
			return false;
		}
		
		return true;
	}
	
	public String getNomeSeguradora() {
		return this.nomeSeguradora;
	}
	
	public String getNumeroApolice() {
		return this.numeroApolice;
	}
}
