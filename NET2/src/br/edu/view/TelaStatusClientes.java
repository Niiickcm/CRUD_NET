package br.edu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.edu.bean.Cliente;
import br.edu.bean.ModeloTabela;
import br.edu.dao.NetDAO;

import br.edu.util.ConnectionFactory;
import java.awt.Rectangle;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;


public class TelaStatusClientes extends JInternalFrame {
	private JTable table;
	private Connection con;
	private ResultSet rs;
	private Statement st;


	public  void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaStatusClientes frame = new TelaStatusClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public TelaStatusClientes() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				preencherTable();
			}
		});
		getContentPane().setBounds(new Rectangle(909, 0, 909, 426));

		//this.setLocationRelativeTo(null);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(25, 169, 845, 216);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(e.getClickCount() == 1) {
					JOptionPane.showMessageDialog(null, "Você não pode editar o campo na table");
				}
			}
		});
		scrollPane.setViewportView(table);
		
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(TelaBuscar.class.getResource("/img/application_form_magnify.png")));
		setResizable(true);
		setFrameIcon(new ImageIcon(TelaForumulario.class.getResource("/img/application_double.png")));
		setClosable(true);
		setBackground(Color.LIGHT_GRAY);
		setTitle("Buscar Cliente");


		


	}
	
	
	public void preencherTable() {
		ConnectionFactory conex = new ConnectionFactory();
		try {
			this.con = ConnectionFactory.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("NOME");
		model.addColumn("SEXO");
		model.addColumn("DATA CADASTRO");
		model.addColumn("EMAIL");
		model.addColumn("STATUS");

		try {
			String query = "select * from tbcliente order by numero_cliente";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				model.addRow(new Object[] {
						
					    rs.getString("numero_cliente"),
						rs.getString("nome_cliente"),
						rs.getString("sexoCliente"),
						rs.getString("dataCadastro"),
						rs.getString("email"),
						rs.getString("statusCliente")
				});
			}
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			center.setHorizontalAlignment(SwingConstants.CENTER);
	
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(0).setCellRenderer(center);
			table.getColumnModel().getColumn(1).setPreferredWidth(300);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(1).setCellRenderer(center);
			table.getColumnModel().getColumn(2).setPreferredWidth(50);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(2).setCellRenderer(center);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setResizable(false);
			table.getColumnModel().getColumn(3).setCellRenderer(center);
			table.getColumnModel().getColumn(4).setPreferredWidth(270);
			table.getColumnModel().getColumn(4).setResizable(false);
			table.getColumnModel().getColumn(4).setCellRenderer(center);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setResizable(false);
			table.getColumnModel().getColumn(5).setCellRenderer(center);
			
			//DEFINE A FONTE
			table.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
			//NÃO PERMITE A REORDENAÇÃO DAS COLUNAS
			table.getTableHeader().setReorderingAllowed(false);
			table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
			table.setSelectionMode(0);
			table.setFocusable(false);
		
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "erro ao inserir dados na tabela " + ex);
		}
		
	}
	
	
}
