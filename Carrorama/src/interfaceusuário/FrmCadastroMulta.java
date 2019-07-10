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
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
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
	public FrmCadastroMulta() {
		
		ArrayList<Veiculo> veiculos;
		FrmCadastroVeiculo frameVeiculo = new FrmCadastroVeiculo();
		veiculos = frameVeiculo.getListVeiculos();
		frameVeiculo.dispose();
		
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
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(veiculoCadastrado) {
						Multa multaCadastro = new Multa("Multa", txtData.toString(), Double.parseDouble(txtValor.toString()));
						for(Veiculo veiculo : veiculos) {
							if(veiculo.getPlaca() == txtPlacaVeiculo.toString() &&  util.ValidarCamposCadastroVeiculo(veiculo)) {
								int indiceVeiculo = veiculos.indexOf(veiculo);
								Veiculo novoVeiculo = (Veiculo) veiculos.subList(indiceVeiculo, indiceVeiculo);
								novoVeiculo.despesasVeiculo.add(multaCadastro);
								veiculos.remove(veiculo);
								veiculos.add(novoVeiculo);
								
							}else {
								Exception e = new Exception();
								throw new excecoes.CombustivelIncompativelException("Veículo Inválido", e);
							}
							
						}
						JOptionPane.showConfirmDialog(contentPane, "Manutenção Cadastrada com Sucesso!", "Cadastro Abastecimento", JOptionPane.OK_OPTION);
					}else {
						Exception e = new Exception();
						throw new excecoes.DescriçãoEmBrancoException("Veículo não cadastrado!!", e);
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Manutenção", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(143, 94, 114, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblPlacaVeculo = new JLabel("Placa Veículo:");
		lblPlacaVeculo.setBounds(17, 64, 114, 15);
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
		txtPlacaVeiculo.setBounds(153, 62, 124, 19);
		contentPane.add(txtPlacaVeiculo);
		txtPlacaVeiculo.setColumns(10);
	}

}
