package proprietario;

import despesas.Despesas;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Veiculo {

	private String marca;
	private String cor;
	private String modelo;
	private int anoDeFabricacao;
	private int anoDoModelo;
	private String placa;
	private int capacidade;
	private int renavam;
	private int tipoDeCombustivel;
	private int combustivelAtual;
	private double motorizacao;
	private ArrayList <Despesas> despesasVeiculo = new ArrayList();
	
	public static Veiculo Init() {
		try {
			
			String modeloVeiculo = JOptionPane.showInputDialog("Modelo:");
			String corVeiculo = JOptionPane.showInputDialog("Cor do veículo:");
			String marca = JOptionPane.showInputDialog("Marca:");
			String anoDeFabricacao = JOptionPane.showInputDialog("Ano de Fabricação:");
			String anoDoModelo = JOptionPane.showInputDialog("Ano do Modelo:");
			String placa = JOptionPane.showInputDialog("Placa:");
			String capacidade = JOptionPane.showInputDialog("Capacidade do Tanque:");
			String renavam = JOptionPane.showInputDialog("Renavam:");
			String[] opcoesCombustivel = {"1 - Gasolina", "2 - Álcool", "3 - Diesel", "4 - Flex"};
			String tipoCombustivel = Integer.toString(JOptionPane.showOptionDialog(null,"Tipo de Combustível:", "Carrorama", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesCombustivel, opcoesCombustivel[0]));;
			String combustivelAtual = JOptionPane.showInputDialog("Quantidade de combustível atual:");
			String motorizacao = JOptionPane.showInputDialog("Motorização do veículo:");
			Veiculo novoVeiculo = new Veiculo(marca, corVeiculo, modeloVeiculo, anoDeFabricacao, anoDoModelo, placa, capacidade, renavam, tipoCombustivel, combustivelAtual,motorizacao);

			return novoVeiculo;
		}catch(Exception e){
			return null;
		}
		
		
	}

	public Veiculo(String marca, String cor, String modelo, String anoDeFabricacao, String anoDoModelo, String placa, String capacidadeTanque, String renavam, String tipoDeCombustivel, String combustivelAtual, String motorizacao) {
		
		this.marca = marca;
		this.cor = cor;
		this.modelo = modelo;
		this.anoDeFabricacao = Integer.parseInt(anoDeFabricacao);
		this.anoDoModelo = Integer.parseInt(anoDoModelo);
		this.placa = placa;
		this.capacidade = Integer.parseInt(capacidadeTanque);
		this.renavam = Integer.parseInt(renavam);
		this.tipoDeCombustivel = Integer.parseInt(tipoDeCombustivel);
		this.combustivelAtual = Integer.parseInt(combustivelAtual);		
		this.motorizacao = Integer.parseInt(motorizacao);
	}
	
	public Veiculo() {
		
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
		return placa;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public int getRenavam() {
		return renavam;
	}

	public int getTipoDeCombutivel() {
		return tipoDeCombustivel;
	}

	public int getCombustivelAtual() {
		return combustivelAtual;
	}

	public double getMotorizacao() {
		return motorizacao;
	}

}
