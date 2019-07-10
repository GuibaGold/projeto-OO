package interfaceusuário;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import despesas.Abastecimento;
import proprietario.Veiculo;
import util.util;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrmCadastroAbastecimento extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataAbastecimento;
	private JTextField txtQuilometragem;
	private JTextField txtValorLitro;
	private boolean veiculoCadastrado;
	private JTextField txtValorTotal;
	

	/**
	 * Create the frame.
	 */
	public FrmCadastroAbastecimento(ArrayList<Veiculo> veiculos) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle("Abastecimento");
		setBackground(new Color(119, 136, 153));
		setBounds(100, 100, 382, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAbastecimento = new JLabel("Placa do Veículo:");
		lblAbastecimento.setBounds(22, 12, 137, 15);
		contentPane.add(lblAbastecimento);
		
		JLabel lblDataAbastecimento = new JLabel("Data Abastecimento:");
		lblDataAbastecimento.setBounds(22, 39, 150, 15);
		contentPane.add(lblDataAbastecimento);
		
		txtDataAbastecimento = new JTextField();
		txtDataAbastecimento.setBounds(190, 37, 161, 19);
		contentPane.add(txtDataAbastecimento);
		txtDataAbastecimento.setColumns(10);
		
		JLabel lblTipoDeCombustvel = new JLabel("Tipo de Combustível:");
		lblTipoDeCombustvel.setBounds(22, 66, 150, 15);
		contentPane.add(lblTipoDeCombustvel);
		
		JLabel lblQuilometragem = new JLabel("Quilometragem:");
		lblQuilometragem.setBounds(22, 93, 150, 15);
		contentPane.add(lblQuilometragem);
		
		txtQuilometragem = new JTextField();
		txtQuilometragem.setBounds(190, 91, 161, 19);
		contentPane.add(txtQuilometragem);
		txtQuilometragem.setColumns(10);
		
		JComboBox comboTipoCombustivel = new JComboBox();
		comboTipoCombustivel.setModel(new DefaultComboBoxModel(new String[] {"Gasolina", "Álcool", "Diesel"}));
		comboTipoCombustivel.setBounds(190, 61, 161, 24);
		contentPane.add(comboTipoCombustivel);
		
		JComboBox comboVeiculos = new JComboBox();
		DefaultComboBoxModel modelo = (DefaultComboBoxModel)comboVeiculos.getModel();
		for(Veiculo veiculo : veiculos) {
			
			modelo.addElement(veiculo.getPlaca());
		}
		comboVeiculos.setModel(modelo);
		comboVeiculos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				for(Veiculo veiculo : veiculos) {
					if(veiculo.getPlaca() == comboVeiculos.getSelectedItem().toString()) {
						veiculoCadastrado = true;
					}
				}
			}
		});
		
		comboVeiculos.setBounds(190, 7, 161, 24);
		contentPane.add(comboVeiculos);
		
		
		
		JLabel lblValorDoCombustivel = new JLabel("Valor do combustivel / L (R$):");
		lblValorDoCombustivel.setBounds(22, 120, 216, 15);
		contentPane.add(lblValorDoCombustivel);
		
		txtValorLitro = new JTextField();
		txtValorLitro.setBounds(297, 118, 54, 19);
		contentPane.add(txtValorLitro);
		txtValorLitro.setColumns(10);
		
		JCheckBox chckbxTanqueCheio = new JCheckBox("Tanque Cheio");
		chckbxTanqueCheio.setBounds(22, 143, 126, 23);
		contentPane.add(chckbxTanqueCheio);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(veiculoCadastrado) {
						Abastecimento abastecimentoCadastro = new Abastecimento(txtDataAbastecimento.getText(), "Abastecimento", 
								comboTipoCombustivel.getSelectedItem().toString(), Integer.parseInt(txtQuilometragem.getText()), Double.parseDouble(txtValorLitro.getText()), Double.parseDouble(txtValorTotal.getText()), chckbxTanqueCheio.isSelected());
						double quantidadeAbastecida = Double.parseDouble(txtValorTotal.getText()) / Double.parseDouble(txtValorLitro.getText());
						for(Veiculo veiculo : veiculos) {
							String placaCadastro = comboVeiculos.getSelectedItem().toString().toUpperCase();
							String tipoCombustivelCadastro =  comboTipoCombustivel.getSelectedItem().toString().toUpperCase();
							String placaVeiculo = veiculo.getPlaca();
							String tipoCombustivelVeiculo = veiculo.getTipoDeCombutivel();
							if(placaVeiculo.equals(placaCadastro) && tipoCombustivelVeiculo.equals(tipoCombustivelCadastro)) {
								boolean validacao =  util.ValidarCadastroAbastecimento(veiculo, comboTipoCombustivel.getSelectedItem().toString().toUpperCase(), quantidadeAbastecida);
								int indiceVeiculo = veiculos.indexOf(veiculo);
								Veiculo novoVeiculo = veiculo;
								veiculo.despesasVeiculo.add(abastecimentoCadastro);
								veiculos.remove(veiculo);
								veiculos.add(novoVeiculo);
								
							}else {
								Exception e = new Exception();
								throw new excecoes.CombustivelIncompativelException("Veículo Inválido", e);
							}
							
						}
						JOptionPane.showConfirmDialog(contentPane, "Abastecimento Cadastrado com Sucesso!", "Cadastro Abastecimento", JOptionPane.PLAIN_MESSAGE);
					}else {
						Exception e = new Exception();
						throw new excecoes.ValorInvalidoException("Veículo não Cadastrado",e);
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Abastecimento", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(227, 222, 114, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(22, 173, 66, 15);
		contentPane.add(lblTotal);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setBounds(297, 171, 54, 19);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		
	}
}
