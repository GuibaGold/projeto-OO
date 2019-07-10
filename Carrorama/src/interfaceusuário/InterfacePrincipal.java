package interfaceusuário;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaceusuário.FrmCadastroDespesa;
import interfaceusuário.FrmCadastroVeiculo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window.Type;

public class InterfacePrincipal extends JFrame {

	private JPanel contentPane;
	private static InterfacePrincipal frame = new InterfacePrincipal();

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
				new FrmCadastroVeiculo().setVisible(true);
			}
		});
		btnCadastrarVeculo.setBounds(54, 36, 154, 25);
		getContentPane().add(btnCadastrarVeculo);
		
		JButton btnCadastrarDespesa = new JButton("Cadastrar Despesa");
		btnCadastrarDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmCadastroDespesa().setVisible(true);
			}
		});
		btnCadastrarDespesa.setBounds(54, 67, 162, 25);
		getContentPane().add(btnCadastrarDespesa);
		
		JButton btnRelatrio = new JButton("Relatório");
		btnRelatrio.setBounds(54, 104, 95, 25);
		getContentPane().add(btnRelatrio);
		
		JButton btnRelatrioDesempenho = new JButton("Relatório Desempenho");
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
