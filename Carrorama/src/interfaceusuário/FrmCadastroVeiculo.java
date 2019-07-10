package interfaceusuário;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proprietario.Veiculo;
import util.util;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmCadastroVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtPlaca;
	private JTextField txtCapacidadeTanque;
	private JTextField txtRenavam;
	private JTextField qtdeCombustivel;
	private JTextField txtMotor;
	private JTextField txtCor;
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	/**
	 * Create the frame.
	 */
	public FrmCadastroVeiculo() {
		
		
		setTitle("Cadastro Veículo");
		setBackground(new Color(119, 136, 153));
		setBounds(100, 100, 390, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(12, 12, 78, 15);
		contentPane.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(108, 10, 267, 19);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 39, 66, 15);
		contentPane.add(lblMarca);
		
		JLabel lblAnoDeFabricao = new JLabel("Ano de fabricação:");
		lblAnoDeFabricao.setBounds(12, 66, 189, 15);
		contentPane.add(lblAnoDeFabricao);
		
		JComboBox comboAnoFabricacao = new JComboBox();
		comboAnoFabricacao.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011"}));
		comboAnoFabricacao.setSelectedIndex(0);
		comboAnoFabricacao.setBounds(297, 61, 78, 24);
		contentPane.add(comboAnoFabricacao);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(108, 37, 267, 19);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblAnoModelo = new JLabel("Ano do modelo:");
		lblAnoModelo.setBounds(12, 93, 137, 15);
		contentPane.add(lblAnoModelo);
		
		JComboBox comboAnoModelo = new JComboBox();
		comboAnoModelo.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011"}));
		comboAnoModelo.setSelectedIndex(0);
		comboAnoModelo.setBounds(297, 88, 78, 24);
		contentPane.add(comboAnoModelo);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(12, 131, 66, 15);
		contentPane.add(lblPlaca);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(108, 129, 267, 19);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Capacidade do Tanque:");
		lblNewLabel.setBounds(12, 158, 174, 15);
		contentPane.add(lblNewLabel);
		
		txtCapacidadeTanque = new JTextField();
		txtCapacidadeTanque.setBounds(204, 156, 171, 19);
		contentPane.add(txtCapacidadeTanque);
		txtCapacidadeTanque.setColumns(10);
		
		JLabel lblRenavam = new JLabel("Renavam:");
		lblRenavam.setBounds(12, 185, 78, 15);
		contentPane.add(lblRenavam);
		
		txtRenavam = new JTextField();
		txtRenavam.setBounds(108, 183, 267, 19);
		contentPane.add(txtRenavam);
		txtRenavam.setColumns(10);
		
		JLabel lblTipoDeCombustvel = new JLabel("Tipo de Combustível:");
		lblTipoDeCombustvel.setBounds(12, 212, 161, 15);
		contentPane.add(lblTipoDeCombustvel);
		
		JComboBox comboTipoCombustivel = new JComboBox();
		comboTipoCombustivel.setModel(new DefaultComboBoxModel(new String[] {"Gasolina", "Álcool", "Diesel", "Flex"}));
		comboTipoCombustivel.setSelectedIndex(0);
		comboTipoCombustivel.setBounds(251, 207, 124, 24);
		contentPane.add(comboTipoCombustivel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade de combustível atual:");
		lblNewLabel_1.setBounds(12, 239, 240, 15);
		contentPane.add(lblNewLabel_1);
		
		qtdeCombustivel = new JTextField();
		qtdeCombustivel.setBounds(251, 237, 124, 19);
		contentPane.add(qtdeCombustivel);
		qtdeCombustivel.setColumns(10);
		
		JLabel lblMotorizaoDoVeculo = new JLabel("Motorização do veículo:");
		lblMotorizaoDoVeculo.setBounds(12, 266, 174, 15);
		contentPane.add(lblMotorizaoDoVeculo);
		
		txtMotor = new JTextField();
		txtMotor.setBounds(251, 264, 124, 19);
		contentPane.add(txtMotor);
		txtMotor.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Veiculo novoVeiculo = new Veiculo(txtModelo.toString(), txtCor.toString(), txtMarca.toString(),
							comboAnoFabricacao.getSelectedItem().toString(), comboAnoModelo.getSelectedItem().toString(), txtPlaca.toString(), 
							txtCapacidadeTanque.toString(), txtRenavam.toString(), comboTipoCombustivel.getSelectedItem().toString(), qtdeCombustivel.toString(),
							txtMotor.toString());
					
					if(util.ValidarCamposCadastroVeiculo(novoVeiculo)) {
						veiculos.add(novoVeiculo);
					}
					else {
						throw new excecoes.DescriçãoEmBrancoException();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnSalvar.setBounds(261, 335, 114, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(12, 293, 66, 15);
		contentPane.add(lblCor);
		
		txtCor = new JTextField();
		txtCor.setBounds(77, 291, 124, 19);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		
		
	}
	
	public ArrayList<Veiculo> getListVeiculos() {
		if(veiculos != null) {
			return veiculos;
		}
		else {
			return null;
		}
	}
}
