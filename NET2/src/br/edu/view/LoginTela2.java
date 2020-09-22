package br.edu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import br.edu.bean.Cliente;
import br.edu.bean.LoginBean;
import br.edu.dao.Login;

public class LoginTela2 extends JFrame {

	public JPanel contentPane;
    public Label lblNome;
    private Login logon;
    private LoginBean bean;
    private TelaPrincipal tela;
    private LoginTela1 login1;
    private JLabel lblLogin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTela2 frame = new LoginTela2();
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
	public LoginTela2() {
		
		try {
			login1 = new LoginTela1();
			logon = new Login();
			 bean = new LoginBean();
			 tela = new TelaPrincipal();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginTela2.class.getResource("/img/logo2.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(null ,"Tem certeza que deseja sair?", "Saída",JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					repaint();
				}
			}
		});
		setBounds(100, 100, 889, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);  

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 883, 532);
		contentPane.add(panel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 678, 68);
		panel.add(menuBar);

		JMenu mnConfidencial = new JMenu("Confidencial");
		mnConfidencial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					JOptionPane.showMessageDialog(null, "Opção Indisponível no momento.","Ops", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		mnConfidencial.setFont(new Font("Arial Black", Font.BOLD, 15));
		mnConfidencial.setForeground(new Color(0, 153, 255));
		menuBar.add(mnConfidencial);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		menuBar.add(separator);

		JMenu mnConfidencial_1 = new JMenu("Confidencial");
		mnConfidencial_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					JOptionPane.showMessageDialog(null, "Opção Indisponível no momento.","Ops", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		mnConfidencial_1.setForeground(new Color(0, 153, 255));
		mnConfidencial_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		menuBar.add(mnConfidencial_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		menuBar.add(separator_1);

		JMenu mnIndividual = new JMenu("Individual");
		mnIndividual.setFont(new Font("Arial Black", Font.BOLD, 15));
		mnIndividual.setForeground(new Color(0, 153, 255));
		menuBar.add(mnIndividual);

		JMenuItem mntmColetivo = new JMenuItem("Coletivo");
		mntmColetivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					JOptionPane.showMessageDialog(null, "Opção Indisponível no momento.","Ops", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		mntmColetivo.setFont(new Font("Arial Black", Font.BOLD, 13));
		mntmColetivo.setForeground(new Color(0, 153, 255));
		mnIndividual.add(mntmColetivo);

		JSeparator separator_3 = new JSeparator();
		mnIndividual.add(separator_3);

		JMenuItem mntmIndividual = new JMenuItem("Individual");
		mntmIndividual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		mntmIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaPrincipal tela;
				try {
					tela = new TelaPrincipal();

					if(tela.isVisible() ){
						
						JOptionPane.showMessageDialog(null, "Você não pode abrir 2 telas ao mesmo tempo! ","Operação Inválida",1);
					}else{

						tela.setVisible(true);
						
						
					}
					
				}catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
				
				
			}
			
		});
		
		mntmIndividual.setFont(new Font("Arial Black", Font.BOLD, 13));
		mntmIndividual.setForeground(new Color(0, 153, 255));
		mnIndividual.add(mntmIndividual);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		menuBar.add(separator_2);

		JMenu mnAdministrativo = new JMenu("Administrativo");
		mnAdministrativo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(arg0.getClickCount() == 1) {
					JOptionPane.showMessageDialog(null, "Opção Indisponível no momento.","Ops", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		mnAdministrativo.setFont(new Font("Arial Black", Font.BOLD, 15));
		mnAdministrativo.setForeground(new Color(0, 153, 255));
		menuBar.add(mnAdministrativo);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginTela2.class.getResource("/img/logoNet.jpg")));
		label.setBounds(55, 137, 737, 297);
		panel.add(label);

		JButton button = new JButton("Sair");
		button.setIcon(new ImageIcon(LoginTela2.class.getResource("/img/cancel.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair ?","Saída", JOptionPane.YES_NO_OPTION);
				if( i == JOptionPane.YES_OPTION) {
					LoginTela1 tl1 = new LoginTela1();

					tl1.setVisible(true);
					dispose();
				} else {
					repaint();
				}

			}
		});
		button.setBounds(733, 42, 89, 26);
		button.setToolTipText("Sair e voltar para tela de login");
		panel.add(button);
        
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(22, 79, 838, 418);
		panel.add(panel_2);
		
		lblLogin = new JLabel("");
		lblLogin.setBounds(733, 26, 89, 14);
		panel.add(lblLogin);
		lblLogin.setText("");
		
        

	}
	public void exportarNome(LoginBean model ) {
      
        this.lblLogin.setText(model.getNome());
		
	}
}
