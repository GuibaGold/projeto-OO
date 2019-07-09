package util;

import proprietario.Veiculo;

public class util {
	
	public static boolean ValidarCamposCadastroVeiculo(Veiculo veiculoCadastro) {
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
		}else if(veiculoCadastro.getCapacidade() < 1) {
			return false;
		}else if(veiculoCadastro.getCombustivelAtual() < 0){
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
		else {
			return true;
		}
	}
}
