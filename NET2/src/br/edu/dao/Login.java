package br.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.Caret;

import br.edu.util.ConnectionFactory;
import br.edu.view.LoginTela2;




public class Login {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private br.edu.bean.LoginBean login;



	public Login() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	public void Salvar(br.edu.bean.LoginBean login) throws Exception {
		if (login == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO tblogin (nome,senha) values ( ?, ?)";

			conn = this.conn;
			ps = conn.prepareStatement(SQL);


			ps.setString(1, login.getNome());
			ps.setString(2, login.getSenha());


			ps.executeUpdate();

		} catch (SQLException e) {
			throw new Exception("Erro ao inserir dados " + e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	public boolean consultarLogin (String nome, String senha){
		// Manda como parametro para ele duas variaveis para ele procurar no banco de dados!
		try {

			String sql;
			sql = "SELECT * FROM tblogin WHERE nome = ? and senha = ?";
			boolean autenticado = false;
			ps = conn.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, senha);

			ResultSet rs;
			rs = ps.executeQuery();

			if (rs.next()) {

				autenticado = true;

			}

			ps.close();


			return autenticado;

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Erro ao recuperar cliente/ senha");
			throw new RuntimeException();
		}




	}

	
}	


