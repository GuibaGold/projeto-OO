package interfaceusuário;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import despesas.Imposto;
import proprietario.Veiculo;
import util.util;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCadastroImposto extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlacaVeiculo;
	private JTextField txtDataPagamento;
	private JTextField txtValorParcela;
	private JTextField txtValorTotal;
	private boolean veiculoCadastrado = false;
	
	/**
	 * Create the frame.
	 */
	public FrmCadastroImposto() {
		setTitle("Imposto");
		setBackground(new Color(119, 136, 153));
		ArrayList<Veiculo> veiculos;
		FrmCadastroVeiculo frameVeiculo = new FrmCadastroVeiculo();
		veiculos = frameVeiculo.getListVeiculos();
		frameVeiculo.dispose();
		
		setBounds(100, 100, 266, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImposto = new JLabel("Imposto:");
		lblImposto.setBounds(12, 12, 66, 15);
		contentPane.add(lblImposto);
		
		JComboBox comboTpImposto = new JComboBox();
		comboTpImposto.setModel(new DefaultComboBoxModel(new String[] {"IPVA", "DPVAT", "Licenciamento"}));
		comboTpImposto.setBounds(153, 7, 79, 24);
		contentPane.add(comboTpImposto);
		
		JLabel lblPlacaVeculo = new JLabel("Placa Veículo");
		lblPlacaVeculo.setBounds(12, 47, 106, 15);
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
		txtPlacaVeiculo.setBounds(146, 45, 86, 19);
		contentPane.add(txtPlacaVeiculo);
		txtPlacaVeiculo.setColumns(10);
		
		JLabel lblDataPagamento = new JLabel("Data Pagamento:");
		lblDataPagamento.setBounds(12, 68, 127, 15);
		contentPane.add(lblDataPagamento);
		
		txtDataPagamento = new JTextField();
		txtDataPagamento.setBounds(146, 66, 86, 19);
		contentPane.add(txtDataPagamento);
		txtDataPagamento.setColumns(10);
		
		JLabel lblParcelas = new JLabel("Parcelas:");
		lblParcelas.setBounds(12, 102, 79, 15);
		contentPane.add(lblParcelas);
		
		JComboBox comboQtdeParcelas = new JComboBox();
		comboQtdeParcelas.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboQtdeParcelas.setMaximumRowCount(12);
		comboQtdeParcelas.setBounds(153, 97, 79, 24);
		contentPane.add(comboQtdeParcelas);
		
		JLabel lblValorParcela = new JLabel("Valor Parcela:");
		lblValorParcela.setBounds(12, 129, 106, 15);
		contentPane.add(lblValorParcela);
		
		txtValorParcela = new JTextField();
		txtValorParcela.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int qtdeParcelas = Integer.parseInt(comboQtdeParcelas.getSelectedItem().toString());
				double valorParcela = Double.parseDouble(txtValorParcela.toString());
				txtValorTotal.setText(String.valueOf(qtdeParcelas * valorParcela));
			}
		});
		txtValorParcela.setBounds(146, 127, 86, 19);
		contentPane.add(txtValorParcela);
		txtValorParcela.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(12, 189, 102, 15);
		contentPane.add(lblValorTotal);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setBounds(146, 187, 86, 19);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(veiculoCadastrado) {
						Imposto impostoCadastro = new Imposto("Imposto", txtDataPagamento.toString(), Double.parseDouble(txtValorParcela.toString()), 
								Integer.parseInt(comboQtdeParcelas.getSelectedItem().toString()), comboTpImposto.getSelectedItem().toString());
						for(Veiculo veiculo : veiculos) {
							if(veiculo.getPlaca() == txtPlacaVeiculo.toString() &&  util.ValidarCamposCadastroVeiculo(veiculo)) {
								int indiceVeiculo = veiculos.indexOf(veiculo);
								Veiculo novoVeiculo = (Veiculo) veiculos.subList(indiceVeiculo, indiceVeiculo);
								novoVeiculo.despesasVeiculo.add(impostoCadastro);
								veiculos.remove(veiculo);
								veiculos.add(novoVeiculo);
								
							}else {
								Exception e = new Exception();
								throw new excecoes.CombustivelIncompativelException("Veículo Inválido", e);
							}
							
						}
						JOptionPane.showConfirmDialog(contentPane, "Imposto Cadastrado com Sucesso!", "Cadastro Abastecimento", JOptionPane.OK_OPTION);
					}else {
						Exception e = new Exception();
						throw new excecoes.DescriçãoEmBrancoException("Veículo não cadastrado!!", e);
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Imposto", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSalvar.setBounds(131, 231, 114, 25);
		contentPane.add(btnSalvar);
	}
}
