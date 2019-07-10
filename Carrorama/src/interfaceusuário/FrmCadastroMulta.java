package interfaceusuário;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import despesas.Manutencao;
import despesas.Multa;
import proprietario.Veiculo;
import util.util;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCadastroMulta extends JFrame {

	private JPanel contentPane;
	private JTextField txtData;
	private JTextField txtValor;
	private JTextField txtPlacaVeiculo;
	private boolean veiculoCadastrado = false;

	

	/**
	 * Create the frame.
	 */
	public FrmCadastroMulta(List<Veiculo> veiculos) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		setTitle("Multa");
		setBackground(new Color(119, 136, 153));
		setBounds(100, 100, 300, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(12, 12, 66, 15);
		contentPane.add(lblData);
		
		txtData = new JTextField();
		txtData.setBounds(130, 12, 124, 19);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(15, 42, 66, 15);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(135, 39, 124, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JComboBox comboVeiculos = new JComboBox();
		comboVeiculos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				for(Veiculo veiculo : veiculos) {
					if(veiculo.getPlaca().equals(comboVeiculos.getSelectedItem().toString().toUpperCase())) {
						veiculoCadastrado = true;
					}
				}
			}
		});
		DefaultComboBoxModel modelo = (DefaultComboBoxModel)comboVeiculos.getModel();
		for(Veiculo veiculo : veiculos) {

			modelo.addElement(veiculo.getPlaca());
		}
		comboVeiculos.setModel(modelo);
		comboVeiculos.setBounds(125, 69, 161, 24);
		contentPane.add(comboVeiculos);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(veiculoCadastrado) {
						Multa multaCadastro = new Multa("Multa", txtData.getText(), Double.parseDouble(txtValor.getText()));
						for(Veiculo veiculo : veiculos) {
							if(veiculo.getPlaca().equals(comboVeiculos.getSelectedItem().toString().toUpperCase())&&  util.ValidarCamposCadastroVeiculo(veiculo)) {
								Veiculo novoVeiculo = veiculo;
								novoVeiculo.despesasVeiculo.add(multaCadastro);
								veiculos.remove(veiculo);
								veiculos.add(novoVeiculo);
								
							}else {
								Exception e = new Exception();
								throw new excecoes.CombustivelIncompativelException("Veículo Inválido", e);
							}
							
						}
						JOptionPane.showConfirmDialog(contentPane, "Manutenção Cadastrada com Sucesso!", "Cadastro Abastecimento", JOptionPane.PLAIN_MESSAGE);
					}else {
						Exception e = new Exception();
						throw new excecoes.DescriçãoEmBrancoException("Veículo não cadastrado!!", e);
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Manutenção", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(172, 105, 114, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblPlacaVeculo = new JLabel("Placa Veículo:");
		lblPlacaVeculo.setBounds(12, 75, 114, 15);
		contentPane.add(lblPlacaVeculo);
		
		
	}

}
