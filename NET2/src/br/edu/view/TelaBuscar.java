/*package br.edu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import br.edu.bean.Cliente;
import br.edu.dao.NetDAO;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;

public class TelaBuscar extends JFrame {

		public JTextField txtCod;
		private JTextField txtcod2;
		private JTextField txtCpf;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField txtCidade;
		private JTextField textField_7;
		private JTextField textField_8;
		private JTextField textField_9;
	    JDesktopPane desktop;
		
	    public String nome;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						TelaBuscar frame = new TelaBuscar();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		
		public TelaBuscar() {
			setAlwaysOnTop(true);
			getContentPane().setBackground(SystemColor.activeCaption);
			setIconImage(Toolkit.getDefaultToolkit().getImage(TelaBuscar.class.getResource("/img/application_form_magnify.png")));
			
			//setFrameIcon(new ImageIcon(TelaForumulario.class.getResource("/img/application_double.png")));
			//setClosable(true);
			setBackground(Color.LIGHT_GRAY);
			setTitle("Buscar Cliente");
		
			setBounds(100, 100, 600, 250);
			getContentPane().setLayout(null);
			
			
			
			txtCod = new JTextField();
			txtCod.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			txtCod.setBackground(Color.WHITE);
			txtCod.setBounds(64, 11, 41, 20);
			getContentPane().add(txtCod);
			txtCod.setColumns(10);
			
			txtcod2 = new JTextField();
			txtcod2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			txtcod2.setBounds(115, 11, 108, 20);
			getContentPane().add(txtcod2);
			txtcod2.setColumns(10);
			
			JLabel lblCodigo = new JLabel("Codigo :");
			lblCodigo.setBounds(8, 14, 46, 14);
			getContentPane().add(lblCodigo);
			
			JLabel lblCpf = new JLabel("CPF:");
			lblCpf.setBounds(8, 54, 46, 14);
			getContentPane().add(lblCpf);
			
			txtCpf = new JTextField();
			txtCpf.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			txtCpf.setBounds(44, 51, 179, 20);
			getContentPane().add(txtCpf);
			txtCpf.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Edit1");
			lblNewLabel.setBounds(8, 82, 46, 14);
			getContentPane().add(lblNewLabel);
			
			JLabel lblEdit = new JLabel("Edit2");
			lblEdit.setBounds(8, 115, 46, 14);
			getContentPane().add(lblEdit);
			
			JLabel lblEdit_1 = new JLabel("Edit3");
			lblEdit_1.setBounds(8, 149, 46, 14);
			getContentPane().add(lblEdit_1);
			
			textField_3 = new JTextField();
			textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textField_3.setColumns(10);
			textField_3.setBounds(44, 79, 222, 20);
			getContentPane().add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textField_4.setColumns(10);
			textField_4.setBounds(44, 112, 222, 20);
			getContentPane().add(textField_4);
			
			textField_5 = new JTextField();
			textField_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textField_5.setColumns(10);
			textField_5.setBounds(44, 146, 222, 20);
			getContentPane().add(textField_5);
			
			JLabel lblCidade = new JLabel("Cidade:");
			lblCidade.setBounds(18, 184, 46, 14);
			getContentPane().add(lblCidade);
			
			txtCidade = new JTextField();
			txtCidade.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			txtCidade.setColumns(10);
			txtCidade.setBounds(64, 181, 170, 20);
			getContentPane().add(txtCidade);
			
			textField_7 = new JTextField();
			textField_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textField_7.setColumns(10);
			textField_7.setBounds(344, 79, 222, 20);
			getContentPane().add(textField_7);
			
			textField_8 = new JTextField();
			textField_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textField_8.setColumns(10);
			textField_8.setBounds(344, 112, 222, 20);
			getContentPane().add(textField_8);
			
			textField_9 = new JTextField();
			textField_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textField_9.setColumns(10);
			textField_9.setBounds(344, 146, 222, 20);
			getContentPane().add(textField_9);
			
			JLabel lblEdit_2 = new JLabel("Edit4");
			lblEdit_2.setBounds(298, 82, 46, 14);
			getContentPane().add(lblEdit_2);
			
			JLabel lblEdit_3 = new JLabel("Edit5");
			lblEdit_3.setBounds(298, 115, 46, 14);
			getContentPane().add(lblEdit_3);
			
			JLabel lblEdit_4 = new JLabel("Edit6");
			lblEdit_4.setBounds(298, 149, 46, 14);
			getContentPane().add(lblEdit_4);
			
			JButton btnEntrar = new JButton("Pesquisar");
			btnEntrar.setIcon(null);
			btnEntrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			btnEntrar.setBackground(SystemColor.scrollbar);
			btnEntrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	                
					try {
					Cliente cliente;
					NetDAO dao = new NetDAO();
					
					int cod = Integer.parseInt(txtCod.getText());
					cliente = dao.procurarCliente(cod);
					
					
					
					

				    //exportarNome(cliente);
							
						
							
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro de Consulta : " + ex.getMessage());
					}
						
					
				
				}
			});
			btnEntrar.setBounds(471, 8, 95, 23);
			getContentPane().add(btnEntrar);
			
			JButton btnLimpar = new JButton("Limpar");
			btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnLimpar.setBackground(SystemColor.scrollbar);
			btnLimpar.setBounds(471, 31, 95, 23);
			getContentPane().add(btnLimpar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setIcon(null);
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCancelar.setBackground(SystemColor.scrollbar);
			btnCancelar.setBounds(471, 54, 95, 23);
			getContentPane().add(btnCancelar);
		
			
			  
		}

		private void initComponents() {
			// TODO Auto-generated method stub
			
		}
	}
*/