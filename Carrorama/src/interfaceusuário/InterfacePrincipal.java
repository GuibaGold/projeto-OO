package interfaceusuário;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfaceusuário.FrmCadastroDespesa;
import interfaceusuário.FrmCadastroVeiculo;
import proprietario.Veiculo;
import relatorios.RelatorioDeDesempenho;
import relatorios.RelatorioSimples;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window.Type;

public class InterfacePrincipal extends JFrame {

	private JPanel contentPane;
	private static InterfacePrincipal frame = new InterfacePrincipal();
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	private FrmCadastroVeiculo cadastroVeiculo = new FrmCadastroVeiculo(veiculos);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public InterfacePrincipal() {
		Dimension screenSize = new Dimension(300,400);
		setType(Type.UTILITY);
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(119, 136, 153));
		getContentPane().setLayout(null);
		this.setSize(screenSize);
		
		JButton btnCadastrarVeculo = new JButton("Cadastrar Veículo");
		btnCadastrarVeculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastroVeiculo.setVisible(true);
			}
		});
		btnCadastrarVeculo.setBounds(54, 36, 154, 25);
		getContentPane().add(btnCadastrarVeculo);
		
		JButton btnCadastrarDespesa = new JButton("Cadastrar Despesa");
		btnCadastrarDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCadastroDespesa frame = new FrmCadastroDespesa(veiculos);
				frame.setVisible(true);
				
			}
		});
		btnCadastrarDespesa.setBounds(54, 67, 162, 25);
		getContentPane().add(btnCadastrarDespesa);
		
		JButton btnRelatrio = new JButton("Relatório");
		btnRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RelatorioSimples.relSimples(veiculos);
			}
		});
		btnRelatrio.setBounds(54, 104, 95, 25);
		getContentPane().add(btnRelatrio);
		
		JButton btnRelatrioDesempenho = new JButton("Relatório Desempenho");
		btnRelatrioDesempenho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RelatorioDeDesempenho.RelDesempenho(veiculos);
			}
		});
		btnRelatrioDesempenho.setBounds(54, 141, 188, 25);
		getContentPane().add(btnRelatrioDesempenho);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnSair.setBounds(54, 178, 61, 25);
		getContentPane().add(btnSair);
		
		
		
		
	}
}
