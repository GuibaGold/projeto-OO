import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import proprietario.FrmCadastroVeiculo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window.Type;

public class InterfacePrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePrincipal frame = new InterfacePrincipal();
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
		btnCadastrarVeculo.setBounds(80, 36, 193, 25);
		getContentPane().add(btnCadastrarVeculo);
		
		JButton btnCadastrarAbastecimento = new JButton("Cadastrar Abastecimento");
		btnCadastrarAbastecimento.setBounds(80, 73, 193, 25);
		getContentPane().add(btnCadastrarAbastecimento);
		
		JButton btnCadastrarDespesa = new JButton("Cadastrar Despesa");
		btnCadastrarDespesa.setBounds(80, 110, 193, 25);
		getContentPane().add(btnCadastrarDespesa);
		
		JButton btnRelatrio = new JButton("Relatório");
		btnRelatrio.setBounds(80, 147, 193, 25);
		getContentPane().add(btnRelatrio);
		
		JButton btnRelatrioDesempenho = new JButton("Relatório Desempenho");
		btnRelatrioDesempenho.setBounds(80, 184, 193, 25);
		getContentPane().add(btnRelatrioDesempenho);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(80, 221, 193, 25);
		getContentPane().add(btnSair);
		
		
		
		
	}
}
