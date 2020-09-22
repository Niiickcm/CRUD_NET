package br.edu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.edu.dao.NetDAO;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	protected JButton btnPrincipal;
	protected JButton btnStatus;
	protected JButton btnCadastro;
	protected JButton btnProtocolos;
	private    JLabel lblContador;
	private  NetDAO dao;

	TelaCadastro cad = new TelaCadastro();
	LoginCadastroUsuario login = new LoginCadastroUsuario();
	TelaForumulario tlf = new TelaForumulario();
	TelaStatusClientes status = new TelaStatusClientes();
    TelaFinanceiro finaceiro = new TelaFinanceiro();
    
    
	public static void main(String[] args) {
		
		
					TelaPrincipal frame;
					try {
						frame = new TelaPrincipal();
						frame.setVisible(true);
						frame.contador();  
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
			}
			
	




	public TelaPrincipal() throws PropertyVetoException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/img/logo2.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 943, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 937, 594);
		contentPane.add(panel);


		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 937, 21);
		panel.add(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivos");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					JOptionPane.showMessageDialog(null, "Opção Indisponível no momento.","Ops", JOptionPane.INFORMATION_MESSAGE);
					

				}
			}
		});
		
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Sele\u00E7\u00E3o");
		menuBar.add(mnNewMenu_1);

		JMenuItem mnNewMenu_5 = new JMenuItem("Cadastrar Cliente");
		mnNewMenu_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TelaCadastrarCliente cad;
				try {
					cad = new TelaCadastrarCliente();
					cad.setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



			}
		});
		mnNewMenu_5.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/user_add.png")));
		mnNewMenu_1.add(mnNewMenu_5);

		JMenu mnNewMenu_2 = new JMenu("Web");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					JOptionPane.showMessageDialog(null, "Opção ainda em desenvolvimento.","Ops", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		menuBar.add(mnNewMenu_2);

		JMenu mnNewMenu_3 = new JMenu("Vers\u00E3o");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Version");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TelaVersao version = new TelaVersao();

				version.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/logo2.png")));
		mnNewMenu_3.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_4 = new JMenu("Adm");
		menuBar.add(mnNewMenu_4);


		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastro Usuario");
		mntmNewMenuItem.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/user_add.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if(login.isVisible() ){
					JOptionPane.showMessageDialog(null, "Você não pode abrir 2 telas ao mesmo tempo! ","Operação Inválida",1);


				}else{

					login.setVisible(true);
				}
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JLabel painel = new JLabel("");
		painel.setBackground(SystemColor.activeCaptionText);
		painel.setBounds(10, 113, 909, 426);
		panel.add(painel);

		JButton btnG = new JButton("");
		btnG.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/application_add.png")));
		btnG.setToolTipText("Formulário de visualização");
		btnG.setBounds(10, 40, 64, 28);
		btnG.setActionCommand("disable");
		panel.add(btnG);

		JButton btnCalc = new JButton("");
		btnCalc.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/calculator.png")));
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Runtime.getRuntime().exec("Calc");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCalc.setBounds(72, 40, 64, 28);
		btnCalc.setToolTipText("Abrir Calculadora");
		panel.add(btnCalc);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 113, 909, 2);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(10, 113, 2, 426);
		panel.add(separator_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(917, 113, 2, 426);
		panel.add(separator_3);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 539, 909, 2);
		panel.add(separator_2);



		JButton btnPrincipal = new JButton("Principal");
		btnPrincipal.setEnabled(false);
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dao.playSounds("/sounds/clickBotao");
				if(tlf.isVisible() ){
					JOptionPane.showMessageDialog(null, "Você não pode abrir 2 telas ao mesmo tempo! ","Operação Inválida",1);

				}else{

					painel.add(tlf);
					
					tlf.setVisible(true);
					status.setVisible(false);
					finaceiro.setVisible(false);
					cad.setVisible(false);
					try {
						tlf.setMaximum(true);
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});
		btnPrincipal.setBounds(10, 89, 89, 23);
		panel.add(btnPrincipal);


		JButton btnStatus = new JButton("status");
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					dao = new NetDAO();


					dao.playSounds("/sounds/clickBotao");
					if(status.isVisible() ){
						JOptionPane.showMessageDialog(null, "Você não pode abrir 2 telas ao mesmo tempo! ","Operação Inválida",1);
						
					}else{

						painel.add(status);
						tlf.setVisible(false);

						status.setVisible(true);
						tlf.setVisible(false);
						finaceiro.setVisible(false);
						cad.setVisible(false);
						

						status.setMaximum(true);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		btnStatus.setEnabled(false);
		btnStatus.setBounds(100, 89, 89, 23);
		panel.add(btnStatus);

		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					
					dao = new NetDAO();


					dao.playSounds("/sounds/clickBotao");
					if(cad.isVisible() ){
						JOptionPane.showMessageDialog(null, "Você não pode abrir 2 telas ao mesmo tempo! ","Operação Inválida",1);
						
					}else{

						painel.add(cad);
						
						cad.setVisible(true);
						tlf.setVisible(false);
						status.setVisible(false);
						finaceiro.setVisible(false);
						
						cad.setMaximum(true);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				


			}
		});
		btnCadastro.setEnabled(false);
		btnCadastro.setBounds(278, 89, 89, 23);
		panel.add(btnCadastro);

		JButton btnProtocolos = new JButton("protocolos");
		btnProtocolos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		btnProtocolos.setEnabled(false);
		btnProtocolos.setBounds(367, 89, 89, 23);
		panel.add(btnProtocolos);

		JLabel lblData = new JLabel("ghfghfgh");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(34, 557, 89, 26);
		panel.add(lblData);



		Date dataSistema = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		lblData.setText(formato.format(dataSistema));

		JLabel lblHora = new JLabel("");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(133, 557, 105, 26);
		panel.add(lblHora);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(20, 554, 190, 29);
		panel.add(panel_1);
		
		JButton btnFinanceiro = new JButton("Financeiro");
		btnFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					dao = new NetDAO();


					dao.playSounds("/sounds/clickBotao");
					if(status.isVisible() ){
						JOptionPane.showMessageDialog(null, "Você não pode abrir 2 telas ao mesmo tempo! ","Operação Inválida",1);
						
					}else{

						painel.add(status);
						
						finaceiro.setVisible(true);
						tlf.setVisible(false);
						status.setVisible(false);
						cad.setVisible(false);
						

						status.setMaximum(true);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFinanceiro.setEnabled(false);
		btnFinanceiro.setBounds(189, 89, 89, 23);
		panel.add(btnFinanceiro);
		
		lblContador = new JLabel("       0");
		lblContador.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContador.setBounds(465, 42, 64, 14);
		panel.add(lblContador);
		
	
		
		

		Thread th = new Thread(new Runnable() { //cria uma thread
			public void run() {
				while(true) { //roda indefinidamente
					Date date = Calendar.getInstance().getTime(); //pega a hora do sistema
					DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
					String today = formatter.format(date);
					lblHora.setText(today);
					
					try {
						Thread.sleep(1000); //espera 1 segundo para fazer a nova evolução
					} catch(InterruptedException ex){
						//é algo terrível a se fazer mas pelo jeito a API medonha do Java exige
					}
				}
			}
		});
		th.start();
		
		
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {

				Boolean verdadeiro = false;

				if ("disable".equals(arg.getActionCommand()) ) {


					btnPrincipal.setEnabled(true);
					btnStatus.setEnabled(true);
					btnCadastro.setEnabled(true);
					btnProtocolos.setEnabled(true);

				} else if(tlf.isClosable() == false){
					btnPrincipal.setEnabled(false);
					btnStatus.setEnabled(false);
					btnCadastro.setEnabled(false);
					btnProtocolos.setEnabled(false);
					btnProtocolos.setEnabled(true);
				}


				if(tlf.isVisible() ){
					JOptionPane.showMessageDialog(null, "Você não pode abrir 2 telas ao mesmo tempo! ","Operação Inválida",1);

				}else{

					painel.add(tlf);
					tlf.setVisible(true);
					try {
						tlf.setMaximum(true);
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}


			}
		});

		
	}
	public void contador() {
		int c = 0;
		while(isVisible()) {
			
			lblContador.setText(c+"");
			c++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}





