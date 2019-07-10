package interfaceusuário;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import despesas.Seguro;
import proprietario.Veiculo;
import util.util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCadastroSeguro extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlacaVeiculo;
	private JTextField txtSeguradora;
	private JTextField txtNumeroApolice;
	private JTextField txtValor;
	private boolean veiculoCadastrado = false;
	private JTextField txtData;

	/**
	 * Create the frame.
	 */
	public FrmCadastroSeguro() {
		setTitle("Seguro");
		ArrayList<Veiculo> veiculos;
		FrmCadastroVeiculo frameVeiculo = new FrmCadastroVeiculo();
		veiculos = frameVeiculo.getListVeiculos();
		frameVeiculo.dispose();
		
		setBackground(new Color(119, 136, 153));
		setBounds(100, 100, 385, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlacaVeculo = new JLabel("Placa Veículo:");
		lblPlacaVeculo.setBounds(12, 6, 104, 15);
		contentPane.add(lblPlacaVeculo);
		
		txtPlacaVeiculo = new JTextField();
		txtPlacaVeiculo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				for(Veiculo veiculo : veiculos) {
					if(veiculo.getPlaca() == txtPlacaVeiculo.toString()) {
						veiculoCadastrado = true;
					}
				}
			}
		});
		txtPlacaVeiculo.setBounds(241, 4, 124, 19);
		contentPane.add(txtPlacaVeiculo);
		txtPlacaVeiculo.setColumns(10);
		
		JLabel lblNomeSeguradora = new JLabel("Nome Seguradora:");
		lblNomeSeguradora.setBounds(12, 29, 147, 15);
		contentPane.add(lblNomeSeguradora);
		
		txtSeguradora = new JTextField();
		txtSeguradora.setBounds(241, 27, 124, 19);
		contentPane.add(txtSeguradora);
		txtSeguradora.setColumns(10);
		
		JLabel lblNmeroApolice = new JLabel("Número Apolice:");
		lblNmeroApolice.setBounds(14, 56, 127, 15);
		contentPane.add(lblNmeroApolice);
		
		txtNumeroApolice = new JTextField();
		txtNumeroApolice.setBounds(241, 54, 124, 19);
		contentPane.add(txtNumeroApolice);
		txtNumeroApolice.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor :");
		lblValor.setBounds(14, 84, 66, 15);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(241, 82, 124, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(veiculoCadastrado) {
						Seguro seguroCadastro = new Seguro("Seguro", txtData.toString(), Double.parseDouble(txtValor.toString()), 
								txtSeguradora.toString(), txtNumeroApolice.toString());
						for(Veiculo veiculo : veiculos) {
							if(veiculo.getPlaca() == txtPlacaVeiculo.toString() && util.ValidarCamposCadastroVeiculo(veiculo)) {
								int indiceVeiculo = veiculos.indexOf(veiculo);
								Veiculo novoVeiculo = (Veiculo) veiculos.subList(indiceVeiculo, indiceVeiculo);
								novoVeiculo.despesasVeiculo.add(seguroCadastro);
								veiculos.remove(veiculo);
								veiculos.add(novoVeiculo);
								
							}else {
								Exception e = new Exception();
								throw new excecoes.CombustivelIncompativelException("Veículo Inválido", e);
							}
							
						}
						JOptionPane.showConfirmDialog(contentPane, "Seguro Cadastrado com Sucesso!", "Cadastro Abastecimento", JOptionPane.OK_OPTION);
					}
					else {
						Exception ex = new Exception();
						throw new excecoes.DescriçãoEmBrancoException("Veículo não Cadastrado!", ex);
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Seguro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(17, 117, 114, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(178, 122, 66, 15);
		contentPane.add(lblData);
		
		txtData = new JTextField();
		txtData.setBounds(287, 116, 80, 19);
		contentPane.add(txtData);
		txtData.setColumns(10);
	}
}
