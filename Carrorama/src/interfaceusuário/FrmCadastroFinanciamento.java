package interfaceusuário;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	public FrmCadastroFinanciamento() {
		setTitle("Financiamento");
		
		ArrayList<Veiculo> veiculos;
		FrmCadastroVeiculo frameVeiculo = new FrmCadastroVeiculo();
		veiculos = frameVeiculo.getListVeiculos();
		frameVeiculo.dispose();
		
		setBackground(new Color(119, 136, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 248, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParcelas = new JLabel("Parcelas:");
		lblParcelas.setBounds(14, 26, 66, 15);
		contentPane.add(lblParcelas);
		
		JLabel lblValorParcela = new JLabel("Valor Parcela:");
		lblValorParcela.setBounds(14, 54, 115, 15);
		contentPane.add(lblValorParcela);
		
		JComboBox comboParcelas = new JComboBox();
		comboParcelas.setModel(new DefaultComboBoxModel(new String[] {"12", "24", "48"}));
		comboParcelas.setMaximumRowCount(3);
		comboParcelas.setBounds(117, 18, 91, 24);
		contentPane.add(comboParcelas);
		
		txtValorParcela = new JTextField();
		txtValorParcela.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				double valorParcela = Double.parseDouble(txtValorParcela.toString());
				int qtdeParcelas = Integer.parseInt(comboParcelas.getSelectedItem().toString());
				txtTotal.setText(String.valueOf(valorParcela * qtdeParcelas));
			}
		});
		txtValorParcela.setBounds(117, 52, 91, 19);
		contentPane.add(txtValorParcela);
		txtValorParcela.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(14, 119, 66, 15);
		contentPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(114, 117, 104, 19);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(veiculoCadastrado) {
						Financiamento seguroCadastro = new Financiamento("Financiamento", txtData.toString(), Double.parseDouble(txtValorParcela.toString()), Integer.parseInt(comboParcelas.getSelectedItem().toString()));
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
						JOptionPane.showConfirmDialog(contentPane, "Financiamento Cadastrado com Sucesso!", "Cadastro Abastecimento", JOptionPane.OK_OPTION);
					}
					else {
						Exception ex = new Exception();
						throw new excecoes.DescriçãoEmBrancoException("Veículo não Cadastrado!", ex);
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Financiamento", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(14, 191, 114, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(12, 88, 66, 15);
		contentPane.add(lblData);
		
		txtData = new JTextField();
		txtData.setBounds(117, 86, 91, 19);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblPlacaVeculo = new JLabel("Placa Veículo:");
		lblPlacaVeculo.setBounds(14, 146, 109, 15);
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
		txtPlacaVeiculo.setBounds(125, 144, 80, 19);
		contentPane.add(txtPlacaVeiculo);
		txtPlacaVeiculo.setColumns(10);
	}
}
