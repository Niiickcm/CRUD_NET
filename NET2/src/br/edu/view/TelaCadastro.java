package br.edu.view;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class TelaCadastro extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setFrameIcon(new ImageIcon(TelaForumulario.class.getResource("/img/application_double.png")));
		setClosable(true);
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setResizable(true);
		setTitle("Dados do Cliente");
		setBounds(100, 100, 909, 425);
		getContentPane().setLayout(null);


	}

}
