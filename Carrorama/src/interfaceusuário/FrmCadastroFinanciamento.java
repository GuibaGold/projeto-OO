package interfaceusuário;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import despesas.Abastecimento;
import despesas.Financiamento;
import despesas.Seguro;
import proprietario.Veiculo;
import util.util;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCadastroFinanciamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtValorParcela;
	private JTextField txtTotal;
	private JTextField txtData;
	private JTextField txtPlacaVeiculo;
	private boolean veiculoCadastrado = false;

	/**
	 * Create the frame.
	 */
	public FrmCadastroFinanciamento(List<Veiculo> veiculos) {
		setTitle("Financiamento");
		
		
		
		setBackground(new Color(119, 136, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 248, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParcelas = new JLabel("Parcelas:");
		lblParcelas.setBounds(16, 69, 66, 15);
		contentPane.add(lblParcelas);
		
		JLabel lblValorParcela = new JLabel("Valor Parcela:");
		lblValorParcela.setBounds(16, 97, 115, 15);
		contentPane.add(lblValorParcela);
		
		JComboBox comboParcelas = new JComboBox();
		comboParcelas.setModel(new DefaultComboBoxModel(new String[] {"12", "24", "48"}));
		comboParcelas.setMaximumRowCount(3);
		comboParcelas.setBounds(119, 61, 91, 24);
		contentPane.add(comboParcelas);
		
		txtValorParcela = new JTextField();
		txtValorParcela.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				double valorParcela = util.getDoubleValue(txtValorParcela.getText());
				int qtdeParcelas = util.getIntegerValue(comboParcelas.getSelectedItem().toString());
				txtTotal.setText(String.valueOf(valorParcela * qtdeParcelas));
			}

			
		});
		txtValorParcela.setBounds(119, 95, 91, 19);
		contentPane.add(txtValorParcela);
		txtValorParcela.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(16, 162, 66, 15);
		contentPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(116, 160, 104, 19);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JComboBox comboVeiculos = new JComboBox();
		comboVeiculos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				for(Veiculo veiculo : veiculos) {
					if(veiculo.getPlaca().contentEquals(comboVeiculos.getSelectedItem().toString().toUpperCase())) {
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
		comboVeiculos.setBounds(119, 26, 91, 24);
		contentPane.add(comboVeiculos);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(veiculoCadastrado) {
						Financiamento financiamentoCadastro = new Financiamento("Financiamento", txtData.getText(), util.getDoubleValue(txtValorParcela.getText()), util.getIntegerValue(comboParcelas.getSelectedItem().toString()));
						for(Veiculo veiculo : veiculos) {
							if(veiculo.getPlaca().toUpperCase().equals(comboVeiculos.getSelectedItem().toString().toUpperCase()))
							Financiamento.CadastrarFinanciamento(financiamentoCadastro, veiculo);
						}
					}else {
						throw new excecoes.ValorInvalidoException("Veículo não Cadastrado");
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane,"Erro ao cadastrar Financiamento: " + e.getMessage(), "Abastecimento", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(14, 191, 114, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(14, 131, 66, 15);
		contentPane.add(lblData);
		
		txtData = new JTextField();
		txtData.setBounds(119, 129, 91, 19);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblPlacaVeculo = new JLabel("Placa Veículo:");
		lblPlacaVeculo.setBounds(16, 31, 109, 15);
		contentPane.add(lblPlacaVeculo);
		
		
	}
}
