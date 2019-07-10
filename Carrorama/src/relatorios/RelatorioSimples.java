package relatorios;
import java.util.ArrayList;
import java.util.List;

import despesas.*;
import interfaceusuário.FrmCadastroVeiculo;
import proprietario.Veiculo;

public class RelatorioSimples {
	
	private String consumo;
	private List<Double> custos = new ArrayList<Double>();
	private List<String> nomesServicos = new ArrayList<String>();
	private List<Despesas> servicos = new ArrayList<Despesas>();
	
	
	
	
	public RelatorioSimples(List<Veiculo> veiculos) {
		
		
		
		for(Veiculo veiculo : veiculos) {
			servicos = veiculo.getListDespesas();
			for(Despesas servico : servicos) {
				nomesServicos.add(servico.getNome());
				custos.add(servico.getValor());
			}
		}
	}
	
	public List<Double> getCustos(){
		return custos;
	}
	
	public List<String> getNomesServicos(){
		return nomesServicos;
	}

}
