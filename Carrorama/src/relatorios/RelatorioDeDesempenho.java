package relatorios;

import java.util.List;

import despesas.*;
import proprietario.*;

public class RelatorioDeDesempenho {
	
	static double kmlit, kmanterior;
	
	
	public static void RelDesempenho(List<Veiculo> veiculos) {
		try {
			int aux = 0;
			for(Veiculo veiculo : veiculos) {
				System.out.println("Veiculo de placa "+ veiculo.getPlaca());
				for(Despesas despesa : veiculo.getListDespesas()) {
					if(despesa instanceof Abastecimento) {
						if(aux==0) {
							if(((Abastecimento) despesa).isTanqueCheio()==true) {
								aux=1;
								kmanterior = ((Abastecimento) despesa).getquilometragem();
							}
						} else {
							if(((Abastecimento) despesa).isTanqueCheio()==true) {
								kmlit = (((Abastecimento) despesa).getquilometragem()-kmanterior)/((despesa.getValor())/((Abastecimento) despesa).getValorDoLitro());    
							} 
						}
					}
				}
			}
		} catch(Exception e) {
			System.out.println("Não há despesa ou veículo");
			e.printStackTrace();
		}
	}

}
