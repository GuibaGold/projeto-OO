import proprietario.Veiculo;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal {

	public static void main(String[] args) {
		String[] options = {"1 - Cadastrar Novo Veículo", "2 - Cadastrar Abastecimento", "3 - Cadastrar Despesa", "4 - Relatório Simples", "5 - Relatório de Desempenho", "0 - Sair"};
		String opcaoMenu = Integer.toString(JOptionPane.showOptionDialog(null, "Selecione uma das opções abaixo:", "Carrorama", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]));
		Veiculo novoVeiculo = new Veiculo();
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		do {
			MenuEscolha(opcaoMenu, novoVeiculo);
			veiculos.add(novoVeiculo);
			opcaoMenu = Integer.toString(JOptionPane.showOptionDialog(null, "Selecione uma das opções abaixo:", "Carrorama", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]));
			
		}while(opcaoMenu != "5" || opcaoMenu == "-1");
	}
	
	private static void MenuEscolha(String opcaoMenu, Veiculo novoVeiculo) {
		switch(opcaoMenu) {
		case "0":
			novoVeiculo = Veiculo.Init();
			break;
		case "1":
			
			break;
		}
		
	}

}
