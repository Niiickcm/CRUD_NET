package br.edu.bean;

public class Cliente {

	private int cod_cliente;
	private String nome_cliente;
	private String endereco_cliente;
	private String telefone;
	private String celular;
	private String rg;
	private String cpf;
	private String sexoCliente;
	private String statusCliente;
	private String email; 
    private String dataCadastro;
    
    
	public Cliente(int cod_cliente, String nome_cliente, String endereco_cliente, String telefone, String celular,
			String rg, String cpf, String sexoCliente, String statusCliente, String email, String dataCadastro) {

		this.cod_cliente = cod_cliente;
		this.nome_cliente = nome_cliente;
		this.endereco_cliente = endereco_cliente;
		this.telefone = telefone;
		this.celular = celular;
		this.rg = rg;
		this.cpf = cpf;
		this.sexoCliente = sexoCliente;
		this.statusCliente = statusCliente;
		this.email = email;
		this.dataCadastro = dataCadastro;
	}


	public int getCod_cliente() {
		return cod_cliente;
	}


	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}


	public String getNome_cliente() {
		return nome_cliente;
	}


	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}


	public String getEndereco_cliente() {
		return endereco_cliente;
	}


	public void setEndereco_cliente(String endereco_cliente) {
		this.endereco_cliente = endereco_cliente;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getSexoCliente() {
		return sexoCliente;
	}


	public void setSexoCliente(String sexoCliente) {
		this.sexoCliente = sexoCliente;
	}


	public String getStatusCliente() {
		return statusCliente;
	}


	public void setStatusCliente(String statusCliente) {
		this.statusCliente = statusCliente;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	


}
