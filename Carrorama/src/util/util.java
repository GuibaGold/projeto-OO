package util;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import proprietario.Veiculo;

public class util {
	
	public static boolean ValidarCamposCadastroVeiculo(Veiculo veiculoCadastro) {
		try {
			String capacidade = veiculoCadastro.getCapacidade();
			String combustivelAtual = veiculoCadastro.getCombustivelAtual();
			if(veiculoCadastro.getMarca() == "") {
				return false;
			}else if(veiculoCadastro.getModelo() == "") {
				return false;
			}else if(veiculoCadastro.getCor() == "") {
				return false;
			}else if(veiculoCadastro.getAnoDeFabricacao() > 2019) {
				return false;
			}else if(veiculoCadastro.getAnoDoModelo() > 2019) {
				return false;
			}else if(Integer.parseInt(capacidade) < 1) {
				return false;
			}else if(Integer.parseInt(combustivelAtual) < 0){
				return false;
			}else if(veiculoCadastro.getMotorizacao() == "") {
				return false;
			}else if(veiculoCadastro.getRenavam().length() < 11 || veiculoCadastro.getRenavam().length() > 11) {
				return false;
			}else if(veiculoCadastro.getPlaca() == "") {
				return false;
			}else if(veiculoCadastro.getTipoDeCombutivel() == "") {
				return false;
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao validar cadastro", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	
	public static double getDoubleValue(String string) {
			if ( "".equals(string) ) {
				return 0;
	    }
	    return Double.parseDouble(string);
			
	}
	
	public static int getIntegerValue(String string) {
		 if ( "".equals(string) ) {
		        return 0;
		    }
		    return Integer.parseInt(string);
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
		}else if(veiculo.getCor() == "") {
			return false;
		}else if(veiculo.getMarca() == "") {
			return false;
		}else if(veiculo.getModelo() == "") {
			return false;
		}else if(veiculo.getMotorizacao() == "") {
			return false;
		}else if(veiculo.getPlaca() == "") {
			return false;
		}else if(veiculo.getRenavam() == "") {
			return false;
		}else if(!veiculo.getTipoDeCombutivel().equals(tipoCombustivel)) {
			return false;
		}
		
		return true;
	}
}
