package relatorios;
import java.util.ArrayList;
import java.util.List;

import despesas.*;
import proprietario.*;
import interfaceusuário.FrmCadastroVeiculo;
import proprietario.Veiculo;

public class RelatorioSimples {
	
	public static void relSimples(List<Veiculo> veiculos) {
		try {
			for(Veiculo veiculo : veiculos) {
				System.out.println("Veiculo de placa "+ veiculo.getPlaca());
				for(Despesas despesa : veiculo.getListDespesas()) {
					if(despesa instanceof Abastecimento) {
						System.out.println(despesa.toString());
					} else if(despesa instanceof Imposto) {
						System.out.println(despesa.toString());
					} else if(despesa instanceof Manutencao) {
						System.out.println(despesa.toString());
					}
				}
			}
		} catch(Exception e) {
			System.out.println("Não há despesa ou veículo");
			e.printStackTrace();
		}
		
	}

}
