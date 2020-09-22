package br.edu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Window.Type;
import java.io.Closeable;

import javax.swing.border.EtchedBorder;

public class TelaLoading extends JFrame {

	private JPanel contentPane;
	private JLabel lblLoading;
	private JLabel lblNewLabel_2;
	int c = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				try {
					TelaLoading frame = new TelaLoading();
					frame.setVisible(true);
					frame.contador();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the frame.
	 */
	public TelaLoading() {
		setUndecorated(true);
		setType(Type.UTILITY);
		setResizable(false);
		setBackground(new Color(0, 191, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 138);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaLoading.class.getResource("/img/Loading2.gif")));
		lblNewLabel.setBounds(117, 42, 161, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Loading...");
		lblNewLabel_1.setBounds(117, 92, 54, 14);
		contentPane.add(lblNewLabel_1);
		
        lblLoading = new JLabel("0");
		lblLoading.setBounds(123, 21, 21, 14);
		contentPane.add(lblLoading);
		
		lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setBounds(146, 21, 42, 14);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(10, 11, 253, 116);
		contentPane.add(panel);
		
		
	}
	public void contador() {
		
		while(c <=100) {
			
			lblLoading.setText(c+"");
			c++;
			try {
				Thread.sleep(10);
				if(c == 101) {
					Frame framee = new Frame();
					framee.dispose();
					LoginTela1 login = new LoginTela1();
					login.setVisible(true);
					Thread.sleep(100);
					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(c == 101) {
			dispose();
		}
	}
}
