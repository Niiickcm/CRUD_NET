package br.edu.dao;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Label;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.edu.bean.Cliente;
import br.edu.util.ConnectionFactory;
import br.edu.view.TelaPrincipal;
import br.edu.view.TelaStatusClientes;




public class NetDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Cliente cliente;
	
	TelaPrincipal tela = new TelaPrincipal();
	
	
	public NetDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	
	
	public void Salvar(Cliente cliente) throws Exception {
		if (cliente == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			 String SQL = "INSERT INTO tbcliente (cod_cliente,nome_cliente,"
					+ "sexoCliente,dataCadastro,endereco_cliente,telefone,"
					+ "celular,cpf,rg,email,statusCliente)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		      conn = this.conn;
		      ps = conn.prepareStatement(SQL);
		  	
		      ps.setInt(1, cliente.getCod_cliente());
		      ps.setString(2, cliente.getNome_cliente());
		      ps.setString(3, cliente.getSexoCliente());
		      ps.setString(4, cliente.getDataCadastro());
		      ps.setString(5, cliente.getEndereco_cliente());
		      ps.setString(6, cliente.getTelefone());
		      ps.setString(7, cliente.getCelular());
		      ps.setString(8, cliente.getCpf());
		      ps.setString(9, cliente.getRg());
		      ps.setString(10, cliente.getEmail());
		      ps.setString(11, cliente.getStatusCliente());
		      
		      ps.executeUpdate();
		      
			} catch (SQLException e) {
				throw new Exception("Erro ao inserir dados " + e);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
	}

  }	
	
	
	
	
	public Cliente procurarCliente(int cod_cliente) throws Exception {
		try {
			String SQL = "SELECT  * FROM tbcliente WHERE cod_cliente=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cod_cliente);			
			rs = ps.executeQuery();
			if (rs.next()) {
				int cod = rs.getInt(1);
				String nome = rs.getString("nome_cliente");
				String endereco = rs.getString("endereco_cliente");
				String telefone = rs.getString("telefone");
				String cell = rs.getString("celular");
				String rg = rs.getString("rg");
				String cpf = rs.getString("cpf");
				String sexo = rs.getString("sexoCliente");
				String status = rs.getString("statusCliente");
				String email = rs.getString("email");
				String dataCadastro = rs.getString("dataCadastro");
				//Date nascimento = rs.getDate();
				cliente = new Cliente(cod, nome, endereco,telefone, cell, rg, cpf,sexo,status,email,dataCadastro);
			}
			return cliente;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	

	public void formatarCampoCPF(JFormattedTextField nome) {
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.install(nome);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar CPF");
		}
		
	}
	
	public void formatarCampoCelular(JFormattedTextField nome) {
		try {
			MaskFormatter mask = new MaskFormatter("(##)#####-####");
			mask.install(nome);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar CPF");
		}
		
	}

	public void formatarCampoTelefone(JFormattedTextField nome) {
		try {
			MaskFormatter mask = new MaskFormatter("(##)####-####");
			mask.install(nome);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar CPF");
		}
		
	}
	
	public void formatarCampoData(JFormattedTextField nome) {
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			mask.install(nome);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar CPF");
		}
		
	}

	public void formatarCampoRG(JFormattedTextField nome) {
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.install(nome);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar CPF");
		}
		
	}
	
	public void playSounds(String nomeDoAudio) {
		URL url = getClass().getResource(nomeDoAudio+".wav");
		AudioClip audio = new Applet().newAudioClip(url);
		audio.play();
	}
	
	
}
