package br.edu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import br.edu.bean.LoginBean;

public class LoginCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JTextField txtSenhaUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCadastroUsuario frame = new LoginCadastroUsuario();
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
	public LoginCadastroUsuario() {
		setTitle("Cadastro de Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setBounds(114, 115, 46, 14);
		contentPane.add(lblNewLabel);

		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBackground(new Color(192, 192, 192));
		txtNomeUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNomeUsuario.setBounds(170, 112, 136, 20);
		contentPane.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setBounds(114, 148, 46, 14);
		contentPane.add(lblSenha);

		txtSenhaUsuario = new JTextField();
		txtSenhaUsuario.setBackground(new Color(192, 192, 192));
		txtSenhaUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSenhaUsuario.setColumns(10);
		txtSenhaUsuario.setBounds(170, 145, 136, 20);
		contentPane.add(txtSenhaUsuario);

		JLabel lblNewLabel_1 = new JLabel("Cadastro Usuario");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		lblNewLabel_1.setBounds(133, 11, 182, 52);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtNomeUsuario.getText().isEmpty() || txtSenhaUsuario.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Você deve preencher os campos ! ");

				}else {
					
					String senha = null;
					String nome = null;
					LoginBean login = new LoginBean();


					try {
						login.setNome(txtNomeUsuario.getText());
						login.setSenha(txtSenhaUsuario.getText());


					}catch(NumberFormatException ea) {
						JOptionPane.showMessageDialog(null, "Você deve preencher os campos : "+ ea.getMessage());
					}

					try {
						br.edu.dao.Login login1 = new br.edu.dao.Login();
						login1.Salvar(login);
						JOptionPane.showMessageDialog(null, "Salvo com sucesso");



					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro ao salvar dados : "+ ex.getMessage());
					}
				} 

			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(170, 226, 121, 23);
		contentPane.add(btnNewButton);
	}
}
