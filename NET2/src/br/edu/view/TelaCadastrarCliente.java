package br.edu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.JTextComponent;

import br.edu.bean.Cliente;
import br.edu.dao.NetDAO;
import javax.swing.JFormattedTextField;
import java.awt.Cursor;

public class TelaCadastrarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JTextField txtCodCliente;
	protected JTextField txtNomeCliente;
	private JRadioButton rdbInativo;
	private JLabel lblNewLabel_6;
	private JLabel lblSexo;
	private JRadioButton rdbMasculino;
	private JRadioButton rdbFeminino;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtEmail;
	private String sexoCliente;
	private String statusCliente;
	private JTextArea txtEnderecoCliente;
	private JFormattedTextField txtCpfCliente;
	private JFormattedTextField txtCelularCliente;
	private JFormattedTextField txtTellCliente;
	private JFormattedTextField txtDataCadastro;
	private JFormattedTextField txtRgCliente;
  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarCliente frame = new TelaCadastrarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public TelaCadastrarCliente() throws Exception {
		
		NetDAO dao = new NetDAO();

		
		
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 507);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setToolTipText("azul");
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Codigo :");
		lblNewLabel.setBounds(18, 28, 46, 14);
		contentPane.add(lblNewLabel);

		txtCodCliente = new JTextField();
		txtCodCliente.setBackground(Color.LIGHT_GRAY);
		txtCodCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCodCliente.setBounds(63, 25, 111, 20);
		contentPane.add(txtCodCliente);
		txtCodCliente.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome :");
		lblNewLabel_1.setBounds(221, 28, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBackground(Color.LIGHT_GRAY);
		txtNomeCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNomeCliente.setForeground(new Color(0, 0, 0));
		txtNomeCliente.setBounds(262, 25, 379, 20);
		contentPane.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("RG :");
		lblNewLabel_2.setBounds(18, 77, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("CPF :");
		lblNewLabel_3.setBounds(221, 77, 46, 14);
		contentPane.add(lblNewLabel_3);


		JLabel lblNewLabel_4 = new JLabel("Tell :");
		lblNewLabel_4.setBounds(456, 77, 46, 14);
		contentPane.add(lblNewLabel_4);
        
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setBounds(440, 111, 46, 14);
		contentPane.add(lblCelular);

		JLabel lblNewLabel_5 = new JLabel("Endere\u00E7o : ");
		lblNewLabel_5.setBounds(18, 111, 65, 14);
		contentPane.add(lblNewLabel_5);

		JRadioButton rdbAtivo = new JRadioButton("Ativo");
		rdbAtivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if(rdbAtivo.isSelected()) {
					statusCliente = "A";
				}else {
					statusCliente = null;
				}
			}
		});
		buttonGroup.add(rdbAtivo);
		rdbAtivo.setBackground(new Color(0, 191, 255));
		rdbAtivo.setBounds(496, 174, 98, 23);
		contentPane.add(rdbAtivo);

		rdbInativo = new JRadioButton("Inativo");
		rdbInativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbInativo.isSelected()) {
					statusCliente = "I";
				}else {
					statusCliente = null;
				}
			}
		});
		buttonGroup.add(rdbInativo);
		rdbInativo.setBackground(new Color(0, 191, 255));
		rdbInativo.setBounds(496, 200, 98, 23);
		contentPane.add(rdbInativo);

		lblNewLabel_6 = new JLabel("Status :");
		lblNewLabel_6.setBounds(440, 145, 46, 14);
		contentPane.add(lblNewLabel_6);

		lblSexo = new JLabel("Sexo :");
		lblSexo.setBounds(440, 237, 46, 14);
		contentPane.add(lblSexo);

		rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(rdbMasculino.isSelected()) {
					sexoCliente = "M";
				}else {
					sexoCliente = null;
				}
			}
		});
		buttonGroup_1.add(rdbMasculino);
		rdbMasculino.setBackground(new Color(0, 191, 255));
		rdbMasculino.setBounds(496, 271, 98, 14);
		contentPane.add(rdbMasculino);

		rdbFeminino = new JRadioButton("Feminino");
		rdbFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(rdbFeminino.isSelected()) {
					sexoCliente = "F";
				}else {
					sexoCliente = null;
				}
			}
		});
		buttonGroup_1.add(rdbFeminino);
		rdbFeminino.setBackground(new Color(0, 191, 255));
		rdbFeminino.setBounds(496, 300, 98, 14);
		contentPane.add(rdbFeminino);

		separator_4 = new JSeparator();
		separator_4.setBounds(456, 165, 149, 2);
		contentPane.add(separator_4);

		separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(456, 166, 2, 60);
		contentPane.add(separator_5);

		separator_6 = new JSeparator();
		separator_6.setBounds(456, 224, 149, 2);
		contentPane.add(separator_6);

		separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(603, 165, 2, 60);
		contentPane.add(separator_7);

		separator = new JSeparator();
		separator.setBounds(456, 262, 149, 2);
		contentPane.add(separator);

		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(456, 262, 2, 60);
		contentPane.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setBounds(456, 321, 149, 2);
		contentPane.add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(603, 262, 2, 60);
		contentPane.add(separator_3);

		JLabel lblData = new JLabel("Data Cadastro :");
		lblData.setBounds(18, 250, 98, 14);
		contentPane.add(lblData);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(412, 358, 46, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEmail.setBackground(Color.LIGHT_GRAY);
		txtEmail.setColumns(10);
		txtEmail.setBounds(451, 355, 190, 20);
		contentPane.add(txtEmail);




		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dao.playSounds("/sounds/clickBotao");
                
				Cliente cliente = new Cliente(getDefaultCloseOperation(), sexoCliente, sexoCliente, sexoCliente, sexoCliente, sexoCliente, sexoCliente, sexoCliente, sexoCliente, sexoCliente, sexoCliente);



				cliente.setCod_cliente(Integer.parseInt(txtCodCliente.getText()));
				cliente.setNome_cliente(txtNomeCliente.getText());
				cliente.setEndereco_cliente(txtEnderecoCliente.getText()); 
				cliente.setTelefone(txtTellCliente.getText());
				cliente.setCelular(txtCelularCliente.getText());
				cliente.setRg(txtRgCliente.getText());
				cliente.setCpf(txtCpfCliente.getText());
				cliente.setSexoCliente(sexoCliente);
				cliente.setStatusCliente(statusCliente);
				cliente.setEmail(txtEmail.getText());
				cliente.setDataCadastro(txtDataCadastro.getText());

				
				if(cliente.equals(" ")) {

					JOptionPane.showInternalMessageDialog(null, "Os campos nao podem ser nulos");
				}else {

					try {
						NetDAO dao = new NetDAO();
						dao.Salvar(cliente);
						JOptionPane.showMessageDialog(null, "Salvo com sucesso");

						txtEnderecoCliente.setText("");
						txtCelularCliente.setText("");
						txtCodCliente.setText("");
						txtCpfCliente.setText("");
						rdbMasculino.setSelected(false);
						rdbFeminino.setSelected(false);
						rdbAtivo.setSelected(false);
						rdbInativo.setSelected(false);
						txtDataCadastro.setText("");
						txtEmail.setText("");
						txtNomeCliente.setText("");
						txtRgCliente.setText("");
						txtTellCliente.setText("");

						TelaStatusClientes status = new TelaStatusClientes();
						
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro ao salvar dados : "+ ex.getMessage());
					}
				}


			}
		});
		btnCadastrar.setBounds(292, 434, 95, 23);
		contentPane.add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtEnderecoCliente.setText("");
				txtCelularCliente.setText("");
				txtCodCliente.setText("");
				txtCpfCliente.setText("");
				txtDataCadastro.setText("");
				txtEmail.setText("");
				txtNomeCliente.setText("");
				txtRgCliente.setText("");
				txtTellCliente.setText("");
			}
		});
		btnLimpar.setBounds(397, 434, 95, 23);
		contentPane.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(187, 434, 95, 23);
		contentPane.add(btnCancelar);

		txtEnderecoCliente = new JTextArea();
		txtEnderecoCliente.setBackground(Color.LIGHT_GRAY);
		txtEnderecoCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEnderecoCliente.setBounds(82, 108, 329, 114);
		txtEnderecoCliente.setLineWrap(true);
		contentPane.add(txtEnderecoCliente);
		
		txtCpfCliente = new JFormattedTextField();
		txtCpfCliente.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtCpfCliente.setCaretPosition(0);
		txtCpfCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCpfCliente.setBackground(Color.LIGHT_GRAY);
		txtCpfCliente.setBounds(262, 74, 143, 20);
		
		contentPane.add(txtCpfCliente);
		dao.formatarCampoCPF(txtCpfCliente);
		
		txtCelularCliente = new JFormattedTextField();
		txtCelularCliente.setCaretPosition(0);
		txtCelularCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCelularCliente.setBackground(Color.LIGHT_GRAY);
		txtCelularCliente.setBounds(498, 108, 143, 20);
		contentPane.add(txtCelularCliente);
		dao.formatarCampoCelular(txtCelularCliente);
		
		txtTellCliente = new JFormattedTextField();
		txtTellCliente.setCaretPosition(0);
		txtTellCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTellCliente.setBackground(Color.LIGHT_GRAY);
		txtTellCliente.setBounds(498, 74, 143, 20);
		contentPane.add(txtTellCliente);
		dao.formatarCampoTelefone(txtTellCliente);
		
		txtDataCadastro = new JFormattedTextField();
		txtDataCadastro.setCaretPosition(0);
		txtDataCadastro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDataCadastro.setBackground(Color.LIGHT_GRAY);
		txtDataCadastro.setBounds(110, 247, 70, 20);
		contentPane.add(txtDataCadastro);
		dao.formatarCampoData(txtDataCadastro);
		
		txtRgCliente = new JFormattedTextField();
		txtRgCliente.setCaretPosition(0);
		txtRgCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtRgCliente.setBackground(Color.LIGHT_GRAY);
		txtRgCliente.setBounds(51, 74, 143, 20);
		contentPane.add(txtRgCliente);
		dao.formatarCampoRG(txtRgCliente);
	}
	
}
