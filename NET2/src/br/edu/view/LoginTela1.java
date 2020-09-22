package br.edu.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.edu.dao.Login;
import br.edu.util.ConnectionFactory;

public class LoginTela1 extends JFrame {

	private JPanel contentPane;
	protected JTextField txtLogin;
	private JPasswordField txtSenha;
	private Login logon;
	private LoginTela2 login;
    private LoginTela2 login2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTela1 frame = new LoginTela1();
					
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
	public LoginTela1() {
		
		try {
			logon = new Login();
			login2 = new LoginTela2();
		   
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginTela1.class.getResource("/img/logo2.png")));
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);  

		JPanel panel = new JPanel();
		panel.setDoubleBuffered(false);
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 914, 532);
		contentPane.add(panel);

		JLabel label = new JLabel("Login:");
		label.setBounds(688, 11, 46, 14);
		panel.add(label);

		JLabel label_1 = new JLabel("Senha:");
		label_1.setBounds(688, 45, 46, 14);
		panel.add(label_1);

		txtLogin = new JTextField();
		txtLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int codigo = e.getKeyCode();
				int tecla  = e.VK_ENTER;

				if(codigo == tecla){
					txtSenha.requestFocus();
				}
			}
		});
		txtLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtLogin.setColumns(10);
		txtLogin.setBounds(731, 8, 118, 20);
		panel.add(txtLogin);

		txtSenha = new JPasswordField();
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				int codigo = e.getKeyCode();
				int tecla  = e.VK_ENTER;

				if(codigo == tecla){


					br.edu.dao.Login dao = null;
					try {
						dao = new br.edu.dao.Login();
					} catch (Exception ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					if(txtLogin.getText().trim().isEmpty() || txtSenha.getText().trim().isEmpty()){
						JOptionPane.showMessageDialog(null, "Você deve digitar um usuario/senha ");
					}
					else if(dao.consultarLogin(txtLogin.getText(),  new String (txtSenha.getPassword()))){
						LoginTela2 tela = new LoginTela2();

						tela.setVisible(true);
						dispose();
					}else  {
						JOptionPane.showMessageDialog(null, " usuario/senha incorreto");
					}
				}
			}
		});

		txtSenha.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSenha.setBounds(731, 42, 118, 20);
		panel.add(txtSenha);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		menuBar.setEnabled(false);
		menuBar.setBackground(SystemColor.text);
		menuBar.setBounds(0, 0, 671, 68);
		panel.add(menuBar);

		JMenu mnConfidencial = new JMenu("Confidencial");
		mnConfidencial.setAlignmentX(Component.LEFT_ALIGNMENT);
		mnConfidencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnConfidencial.setForeground(new Color(0, 153, 255));
		mnConfidencial.setFont(new Font("Arial Black", Font.BOLD, 15));
		menuBar.add(mnConfidencial);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		menuBar.add(separator);

		JMenu mnConfidencial_1 = new JMenu("Confidencial");
		mnConfidencial_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		mnConfidencial_1.setForeground(new Color(0, 153, 255));
		menuBar.add(mnConfidencial_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		menuBar.add(separator_1);

		JMenu mnIndividual = new JMenu("Individual");
		mnIndividual.setForeground(new Color(0, 153, 255));
		mnIndividual.setFont(new Font("Arial Black", Font.BOLD, 15));
		menuBar.add(mnIndividual);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		menuBar.add(separator_2);

		JMenu mnAdministrativo = new JMenu("Administrativo");
		mnAdministrativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, "Opção Indisponvel no momento.");
			}
		});
		mnAdministrativo.setForeground(new Color(0, 153, 255));
		mnAdministrativo.setFont(new Font("Arial Black", Font.BOLD, 15));
		menuBar.add(mnAdministrativo);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(LoginTela1.class.getResource("/img/logoNet.jpg")));
		label_2.setBounds(70, 122, 767, 297);
		panel.add(label_2);

		

		JButton btnEntrar = new JButton("Entrar");

		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {



				br.edu.dao.Login dao = null;
				try {
					dao = new br.edu.dao.Login();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(txtLogin.getText().trim().isEmpty() || txtSenha.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve digitar um usuario/senha ");
				}
				else if(dao.consultarLogin(txtLogin.getText(),  new String (txtSenha.getPassword()))){
					LoginTela2 tela = new LoginTela2();
					tela.setVisible(true);
		
					dispose();
				}else  {
					JOptionPane.showMessageDialog(null, " usuario/senha incorreto");
				}



			}

		});
		btnEntrar.setBounds(741, 73, 96, 23);
		btnEntrar.setToolTipText("Aperte para entrar");
		panel.add(btnEntrar);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(681, 0, 212, 111);
		panel.add(panel_1);
	}
	
	
}
