package proprietario;

import despesas.Despesas;
import excecoes.DescriçãoEmBrancoException;
import util.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Veiculo {

	private String marca;
	private String cor;
	private String modelo;
	private int anoDeFabricacao;
	private int anoDoModelo;
	private String placa;
	private String capacidade;
	private String renavam;
	private String tipoDeCombustivel;
	private String combustivelAtual;
	private String motorizacao;
	public ArrayList <Despesas> despesasVeiculo = new ArrayList<Despesas>();
	
	
	public Veiculo() {
			
	}

	public Veiculo(String placa) {
		this.placa = placa;
	}
	
	public Veiculo(String marca, String cor, String modelo, String anoDeFabricacao, String anoDoModelo, String placa, String capacidadeTanque, String renavam, String tipoDeCombustivel, String combustivelAtual, String motorizacao) {
		
		this.marca = marca;
		this.cor = cor;
		this.modelo = modelo;
		
		this.anoDeFabricacao = Integer.parseInt(anoDeFabricacao);
		this.anoDoModelo = Integer.parseInt(anoDoModelo);
		this.placa = placa.toUpperCase();
		this.capacidade = capacidadeTanque;
		this.renavam = renavam;
		this.tipoDeCombustivel = tipoDeCombustivel.toUpperCase();
		this.combustivelAtual = combustivelAtual;		
		this.motorizacao = motorizacao;
	}
	
	public static void CadastrarVeiculo(Veiculo novoVeiculo, List<Veiculo> veiculos) throws DescriçãoEmBrancoException {
		if(ValidarCamposCadastroVeiculo(novoVeiculo)) {
			veiculos.add(novoVeiculo);
			JOptionPane.showMessageDialog(null, "Cadastro Efetuado com sucesso", "Cadastro Veículo", JOptionPane.PLAIN_MESSAGE);
		}
		else {
			throw new excecoes.DescriçãoEmBrancoException("Verifique se não há nenhum campo preenchido incorretamente...");
		}
	}
	

	private static boolean ValidarCamposCadastroVeiculo(Veiculo veiculoCadastro) {
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
			}else if(util.getDoubleValue(capacidade) < 1) {
				return false;
			}else if(util.getDoubleValue(combustivelAtual) < 0){
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
	
	public String getMarca() {
		return marca;
	}

	public String getCor() {
		return cor;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAnoDeFabricacao() {
		return anoDeFabricacao;
	}

	public int getAnoDoModelo() {
		return anoDoModelo;
	}

	public String getPlaca() {
		return placa.toUpperCase();
	}

	public String getCapacidade() {
		return capacidade;
	}

	public String getRenavam() {
		return renavam;
	}

	public String getTipoDeCombutivel() {
		return tipoDeCombustivel;
	}

	public String getCombustivelAtual() {
		return combustivelAtual;
	}

	public String getMotorizacao() {
		return motorizacao;
	}
	
	public List<Despesas> getListDespesas(){
		return despesasVeiculo;
	}

}
