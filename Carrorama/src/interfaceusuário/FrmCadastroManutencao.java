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
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
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

	/**
	 * Create the frame.
	 */
	public FrmCadastroManutencao() {
		setTitle("Manutenção");
		
		ArrayList<Veiculo> veiculos;
		FrmCadastroVeiculo frameVeiculo = new FrmCadastroVeiculo();
		veiculos = frameVeiculo.getListVeiculos();
		frameVeiculo.dispose();
		
		setBackground(new Color(119, 136, 153));
		setBounds(100, 100, 321, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlacaVeculo = new JLabel("Placa Veículo:");
		lblPlacaVeculo.setBounds(12, 12, 106, 15);
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
		txtPlacaVeiculo.setBounds(161, 13, 124, 19);
		contentPane.add(txtPlacaVeiculo);
		txtPlacaVeiculo.setColumns(10);
		
		JLabel lblQuilometragemAtual = new JLabel("Quilometragem Atual:");
		lblQuilometragemAtual.setBounds(12, 39, 169, 15);
		contentPane.add(lblQuilometragemAtual);
		
		txtQuilometragem = new JTextField();
		txtQuilometragem.setBounds(190, 36, 93, 19);
		contentPane.add(txtQuilometragem);
		txtQuilometragem.setColumns(10);
		
		JLabel lblQuilometragemPrxima = new JLabel("Quilometragem Próxima:");
		lblQuilometragemPrxima.setBounds(17, 63, 196, 15);
		contentPane.add(lblQuilometragemPrxima);
		
		txtValidade = new JTextField();
		txtValidade.setColumns(10);
		txtValidade.setBounds(194, 58, 93, 19);
		contentPane.add(txtValidade);
		
		JLabel lblValor = new JLabel("Valor: ");
		lblValor.setBounds(14, 104, 66, 15);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(164, 103, 124, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(veiculoCadastrado) {
						Manutencao manutencaoCadastro = new Manutencao("Manutencao", txtData.toString(), Double.parseDouble(txtValor.toString()), Double.parseDouble(txtQuilometragem.toString()), Double.parseDouble(txtValidade.toString()));
						for(Veiculo veiculo : veiculos) {
							if(veiculo.getPlaca() == txtPlacaVeiculo.toString() &&  util.ValidarCamposCadastroVeiculo(veiculo)) {
								int indiceVeiculo = veiculos.indexOf(veiculo);
								Veiculo novoVeiculo = (Veiculo) veiculos.subList(indiceVeiculo, indiceVeiculo);
								novoVeiculo.despesasVeiculo.add(manutencaoCadastro);
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
		btnSalvar.setBounds(180, 153, 114, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblNewLabel = new JLabel("Data:");
		lblNewLabel.setBounds(14, 121, 66, 15);
		contentPane.add(lblNewLabel);
		
		txtData = new JTextField();
		txtData.setBounds(174, 124, 124, 19);
		contentPane.add(txtData);
		txtData.setColumns(10);
	}

}
