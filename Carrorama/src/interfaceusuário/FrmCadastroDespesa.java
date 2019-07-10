package interfaceusuário;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCadastroDespesa extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public FrmCadastroDespesa() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastro Despesa");
		setBackground(new Color(119, 136, 153));
		setBounds(100, 100, 239, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarAbastecimento = new JButton("Abastecimento");
		btnCadastrarAbastecimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmCadastroAbastecimento().setVisible(true);
			}
		});
		btnCadastrarAbastecimento.setBounds(12, 12, 207, 25);
		contentPane.add(btnCadastrarAbastecimento);
		
		JButton btnCadastrarFinanciamento = new JButton(" Financiamento");
		btnCadastrarFinanciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmCadastroFinanciamento().setVisible(true);
			}
		});
		btnCadastrarFinanciamento.setBounds(12, 49, 207, 25);
		contentPane.add(btnCadastrarFinanciamento);
		
		JButton btnImposto = new JButton("Imposto");
		btnImposto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmCadastroImposto().setVisible(true);
			}
		});
		btnImposto.setBounds(12, 86, 207, 25);
		contentPane.add(btnImposto);
		
		JButton btnManutencao = new JButton("Manutenção");
		btnManutencao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmCadastroManutencao().setVisible(true);
			}
		});
		btnManutencao.setBounds(12, 123, 207, 25);
		contentPane.add(btnManutencao);
		
		JButton btnMulta = new JButton("Multa");
		btnMulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmCadastroMulta().setVisible(true);
				
			}
		});
		btnMulta.setBounds(12, 160, 207, 25);
		contentPane.add(btnMulta);
		
		JButton btnSeguro = new JButton("Seguro");
		btnSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmCadastroSeguro().setVisible(true);
			}
		});
		btnSeguro.setBounds(12, 196, 207, 25);
		contentPane.add(btnSeguro);
	}
}
