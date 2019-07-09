package util;

import java.util.ArrayList;

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
	
	public static boolean ValidarCadastroAbastecimento(Veiculo veiculo) {
		if(veiculo.getAnoDeFabricacao() > 2019) {
			return false;
		}else if(veiculo.getAnoDoModelo() > 2019) {
			return false;
		}else if(veiculo.getCapacidade() < 1) {
			return false;
		}else if(veiculo.getCombustivelAtual() > veiculo.getCapacidade()) {
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
		}else if(veiculo.getTipoDeCombutivel() == "") {
			return false;
		}
		
		return true;
	}
}
