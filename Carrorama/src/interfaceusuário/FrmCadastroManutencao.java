package interfaceusuário;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import despesas.Imposto;
import despesas.Manutencao;
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

public class FrmCadastroManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlacaVeiculo;
	private JTextField txtQuilometragem;
	private JTextField txtValidade;
	private JTextField txtValor;
	private boolean veiculoCadastrado = false;
	private JTextField txtData;
	private JTextField txtNomeManutencao;

	/**
	 * Create the frame.
	 */
	public FrmCadastroManutencao(List<Veiculo> veiculos) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Manutenção");
		
		
		
		setBackground(new Color(119, 136, 153));
		setBounds(100, 100, 321, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlacaVeculo = new JLabel("Placa Veículo:");
		lblPlacaVeculo.setBounds(12, 12, 106, 15);
		contentPane.add(lblPlacaVeculo);
		
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
		comboVeiculos.setBounds(166, 7, 132, 24);
		contentPane.add(comboVeiculos);
		
		JLabel lblQuilometragemAtual = new JLabel("Quilometragem Atual:");
		lblQuilometragemAtual.setBounds(12, 39, 169, 15);
		contentPane.add(lblQuilometragemAtual);
		
		txtQuilometragem = new JTextField();
		txtQuilometragem.setBounds(190, 37, 93, 19);
		contentPane.add(txtQuilometragem);
		txtQuilometragem.setColumns(10);
		
		JLabel lblQuilometragemPrxima = new JLabel("Quilometragem Próxima:");
		lblQuilometragemPrxima.setBounds(12, 66, 196, 15);
		contentPane.add(lblQuilometragemPrxima);
		
		txtValidade = new JTextField();
		txtValidade.setColumns(10);
		txtValidade.setBounds(190, 67, 93, 19);
		contentPane.add(txtValidade);
		
		JLabel lblValor = new JLabel("Valor: ");
		lblValor.setBounds(12, 95, 66, 15);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(174, 93, 124, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(veiculoCadastrado) {
						Manutencao manutencaoCadastro = new Manutencao("Manutencao - " + txtNomeManutencao.getText(), txtData.getText(), util.getDoubleValue(txtValor.getText()), util.getDoubleValue(txtQuilometragem.getText()), util.getDoubleValue(txtValidade.getText()));
						for(Veiculo veiculo : veiculos) {
							if(veiculo.getPlaca().equals(comboVeiculos.getSelectedItem().toString().toUpperCase())) {
								Manutencao.CadastrarManutencao(manutencaoCadastro, veiculo);
								
							}else {
								throw new excecoes.CombustivelIncompativelException("Veículo Inválido");
							}
						}
						
					}else {
						throw new excecoes.ValorInvalidoException("Veículo não cadastrado.");
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane,"Erro ao cadastrar Manutenção: " + e.getMessage(), "Manutenção" , JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSalvar.setBounds(184, 198, 114, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblNewLabel = new JLabel("Data:");
		lblNewLabel.setBounds(12, 121, 66, 15);
		contentPane.add(lblNewLabel);
		
		txtData = new JTextField();
		txtData.setBounds(174, 119, 124, 19);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblNomeManuteno = new JLabel("Nome Manutenção:");
		lblNomeManuteno.setBounds(12, 149, 142, 15);
		contentPane.add(lblNomeManuteno);
		
		txtNomeManutencao = new JTextField();
		txtNomeManutencao.setBounds(179, 145, 124, 19);
		contentPane.add(txtNomeManutencao);
		txtNomeManutencao.setColumns(10);
	}

}
