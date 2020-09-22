package br.edu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.bean.Cliente;
import br.edu.dao.NetDAO;


public class TelaForumulario extends JInternalFrame {



	private JTextField textCodCliente;
	public JTextField textNomeCliente;
	private JTextField textEndereco;
	private JTextField textTell;
	private JTextField textCelular;
	private JTextField textCPF;
	private JTextField textEmail;
	/*private JTextField textPacote;
	private JTextField textStatusNet;
	private JTextField textStatusEmbratel;*/
	private JTextField textRG;
	private JTable table;
	private JTable table_1;
	private JTextField textSexo;
	private JTextField textData;
	private JLabel lblIcon1;
	private JLabel lblCancelado;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaForumulario frame = new TelaForumulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public TelaForumulario() throws PropertyVetoException {
		setFrameIcon(new ImageIcon(TelaForumulario.class.getResource("/img/application_double.png")));
		setClosable(true);
		getContentPane().setBackground(SystemColor.inactiveCaption);




		setResizable(true);



		setTitle("Formul\u00E1rio");
		setBounds(100, 100, 909, 425);
		getContentPane().setLayout(null);


		JLabel InternalAndInternal = new JLabel("");
		InternalAndInternal.setIcon(null);
		InternalAndInternal.setBounds(155, 49, 600, 250);
		getContentPane().add(InternalAndInternal);

		textCodCliente = new JTextField();
		textCodCliente.setEditable(false);
		textCodCliente.setBounds(0, 0, 128, 34);
		getContentPane().add(textCodCliente);
		textCodCliente.setColumns(10);

		textNomeCliente = new JTextField();
		textNomeCliente.setEditable(false);
		textNomeCliente.setBounds(129, 0, 647, 34);
		getContentPane().add(textNomeCliente);
		textNomeCliente.setColumns(10);

		TelaBuscar busca = new TelaBuscar();



		JButton btnBuscar = new JButton("Buscar ");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBuscar.setIcon(new ImageIcon(TelaForumulario.class.getResource("/img/zoom.png")));
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                   
				if(busca.isVisible() ){
					JOptionPane.showMessageDialog(null, "Você não pode abrir 2 telas ao mesmo tempo! ");


				}else{
					
					getContentPane().setEnabled(false);
					InternalAndInternal.add(busca);
					busca.setVisible(true);
					
					try {
						 
						busca.setMaximum(true);
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					/*try {
						busca.setMaximum(true);
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					  

				}
				textCodCliente.setText("");
                textNomeCliente.setText("");
                textEndereco.setText("");
                textTell.setText("");
                textCelular.setText("");
                textCPF.setText("");
                textEmail.setText("");
                textRG.setText("");
                textSexo.setText("");
                textData.setText("");
                lblIcon1.setText("");
			}



		});
		btnBuscar.setBounds(794, 11, 89, 23);
		getContentPane().add(btnBuscar);

		JLabel lblDadosDoCliente = new JLabel("Dados do Cliente:");
		lblDadosDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDadosDoCliente.setBounds(22, 45, 116, 23);
		getContentPane().add(lblDadosDoCliente);

		textEndereco = new JTextField();
		textEndereco.setEditable(false);
		textEndereco.setBounds(10, 101, 222, 74);
		getContentPane().add(textEndereco);
		textEndereco.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 79, 58, 20);
		getContentPane().add(lblEndereo);



		textTell = new JTextField();
		textTell.setEditable(false);
		textTell.setBounds(255, 61, 137, 20);
		getContentPane().add(textTell);
		textTell.setColumns(10);

		textCelular = new JTextField();
		textCelular.setEditable(false);
		textCelular.setColumns(10);
		textCelular.setBounds(418, 61, 137, 20);
		getContentPane().add(textCelular);

		textCPF = new JTextField();
		textCPF.setEditable(false);
		textCPF.setColumns(10);
		textCPF.setBounds(255, 103, 137, 20);
		getContentPane().add(textCPF);

		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setColumns(10);
		textEmail.setBounds(661, 61, 222, 20);
		getContentPane().add(textEmail);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(255, 45, 46, 14);
		getContentPane().add(lblTelefone);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(255, 85, 46, 14);
		getContentPane().add(lblCpf);

		JLabel lblFoneCel = new JLabel("Fone Celular:");
		lblFoneCel.setBounds(418, 45, 96, 14);
		getContentPane().add(lblFoneCel);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(661, 45, 46, 14);
		getContentPane().add(lblEmail);

		/*textPacote = new JTextField();
		textPacote.setEditable(false);
		textPacote.setBounds(10, 201, 222, 20);
		getContentPane().add(textPacote);
		textPacote.setColumns(10);

		JLabel lblPacotePrincipal = new JLabel("Pacote Principal:");
		lblPacotePrincipal.setBounds(10, 186, 118, 14);
		getContentPane().add(lblPacotePrincipal);

		textStatusNet = new JTextField();
		textStatusNet.setEditable(false);
		textStatusNet.setBounds(255, 161, 180, 60);
		getContentPane().add(textStatusNet);
		textStatusNet.setColumns(10);

		textStatusEmbratel = new JTextField();
		textStatusEmbratel.setEditable(false);
		textStatusEmbratel.setColumns(10);
		textStatusEmbratel.setBounds(468, 161, 180, 60);
		getContentPane().add(textStatusEmbratel);*/

		textRG = new JTextField();
		textRG.setEditable(false);
		textRG.setColumns(10);
		textRG.setBounds(418, 103, 137, 20);
		getContentPane().add(textRG);

		JLabel lblNewLabel = new JLabel("RG:");
		lblNewLabel.setBounds(418, 85, 46, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblStatusNet = new JLabel("Status NET:");
		lblStatusNet.setBounds(255, 145, 77, 14);
		getContentPane().add(lblStatusNet);

		JLabel lblStatusEmbratel = new JLabel("Status Embratel:");
		lblStatusEmbratel.setBounds(468, 145, 96, 14);
		getContentPane().add(lblStatusEmbratel);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Tipo de Ocorr\u00EAncia:", "Ocorr\u00EAncias:"
				}
				));
		table.getColumnModel().getColumn(0).setPreferredWidth(173);
		table.getColumnModel().getColumn(1).setPreferredWidth(450);
		table.setBounds(147, 272, 288, 99);
		getContentPane().add(table);

		table_1 = new JTable();
		table_1.setBounds(488, 272, 288, 99);
		getContentPane().add(table_1);

		textSexo = new JTextField();
		textSexo.setEditable(false);
		textSexo.setColumns(10);
		textSexo.setBounds(22, 222, 103, 23);
		getContentPane().add(textSexo);

		JLabel lblNewLabel_1 = new JLabel("Sexo :");
		lblNewLabel_1.setBounds(22, 197, 46, 14);
		getContentPane().add(lblNewLabel_1);

		textData = new JTextField();
		textData.setEditable(false);
		textData.setColumns(10);
		textData.setBounds(780, 117, 103, 20);
		getContentPane().add(textData);

		JLabel lblNewLabel_2 = new JLabel("Data Cadastro :");
		lblNewLabel_2.setBounds(774, 92, 89, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblIcon1 = new JLabel("");
		lblIcon1.setIcon(null);
		lblIcon1.setBounds(253, 145, 77, 99);
		getContentPane().add(lblIcon1);
		
		lblCancelado = new JLabel("");
		lblCancelado.setIcon(null);
		lblCancelado.setBounds(478, 145, 79, 88);
		getContentPane().add(lblCancelado);





	}

	public void exportarNome(Cliente model ) {
        this.textCodCliente.setText(Integer.toString(model.getCod_cliente()));
		this.textNomeCliente.setText(model.getNome_cliente());
		this.textEndereco.setText(model.getEndereco_cliente());
		this.textTell.setText(model.getTelefone());
		this.textCelular.setText(model.getCelular());
		this.textCPF.setText(model.getCpf());
		this.textRG.setText(model.getRg());
		this.textSexo.setText(model.getSexoCliente());
		if(model.getStatusCliente().equals("A")) {
			this.lblIcon1.setIcon(new ImageIcon(TelaForumulario.class.getResource("/img/positivo.png")));
		}else {
			this.lblIcon1.setIcon(new ImageIcon(TelaForumulario.class.getResource("/img/negativo.png")));
		}
		//this.textStatus.setText(model.getStatusCliente());
		this.textEmail.setText(model.getEmail());
		this.textData.setText(model.getDataCadastro());




	}




	public class TelaBuscar extends JInternalFrame {

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
		/**
		 * Launch the application.
		 */
		public  void main(String[] args) {
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

		/**
		 * Classe TelaBuscar junto com a classe TelaFormulario
		 * Create the frame.
		 */
		public TelaBuscar() {

			//this.setLocationRelativeTo(null);
			getContentPane().setBackground(SystemColor.activeCaption);
			//setIconImage(Toolkit.getDefaultToolkit().getImage(TelaBuscar.class.getResource("/img/application_form_magnify.png")));
			setResizable(true);
			setFrameIcon(new ImageIcon(TelaForumulario.class.getResource("/img/application_double.png")));
			setClosable(true);
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





						exportarNome(cliente);
						dispose();	


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
		

		private void initComponents() throws Exception {
		

		}
	}
}
