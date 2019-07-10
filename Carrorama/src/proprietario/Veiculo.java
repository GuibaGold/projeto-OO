package proprietario;

import despesas.Despesas;
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
	public ArrayList<Despesas> despesasVeiculo = new ArrayList<Despesas>();
	
	
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
