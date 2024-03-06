package com.shomer.dto;


public class Funcionario {

	public Funcionario() {}


	public Funcionario(int idfuncionario, String nomfuncionario, String apelfuncionario, String teloficina,
			String emailfuncionario, int coddependencia) {
	
		this.idfuncionario = idfuncionario;
		this.nomfuncionario = nomfuncionario;
		this.apelfuncionario = apelfuncionario;
		this.teloficina = teloficina;
		this.emailfuncionario = emailfuncionario;
		this.coddependencia = coddependencia;
	}
	
	public Funcionario(String nomfuncionario, String apelfuncionario, String teloficina, String emailfuncionario,
			int coddependencia) {
		super();
		this.nomfuncionario = nomfuncionario;
		this.apelfuncionario = apelfuncionario;
		this.teloficina = teloficina;
		this.emailfuncionario = emailfuncionario;
		this.coddependencia = coddependencia;
	}

	public int getIdfuncionario() {
		return idfuncionario;
	}

	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public String getNomfuncionario() {
		return nomfuncionario;
	}

	public void setNomfuncionario(String nomfuncionario) {
		this.nomfuncionario = nomfuncionario;
	}

	public String getApelfuncionario() {
		return apelfuncionario;
	}

	public void setApelfuncionario(String apelfuncionario) {
		this.apelfuncionario = apelfuncionario;
	}

	public String getTeloficina() {
		return teloficina;
	}

	public void setTeloficina(String teloficina) {
		this.teloficina = teloficina;
	}

	public String getEmailfuncionario() {
		return emailfuncionario;
	}

	public void setEmailfuncionario(String emailfuncionario) {
		this.emailfuncionario = emailfuncionario;
	}

	public int getCoddependencia() {
		return coddependencia;
	}

	public void setCoddependencia(int coddependencia) {
		this.coddependencia = coddependencia;
	}


	@Override
	public String toString() {
		return "Funcionario [idfuncionario=" + idfuncionario + ", nomfuncionario=" + nomfuncionario
				+ ", apelfuncionario=" + apelfuncionario + ", teloficina=" + teloficina + ", emailfuncionario="
				+ emailfuncionario + ", coddependencia=" + coddependencia + "]";
	}


	private int idfuncionario;
	private String nomfuncionario;
	private String apelfuncionario;
	private String teloficina;
	private String emailfuncionario;
	private int coddependencia;
	
	
}
