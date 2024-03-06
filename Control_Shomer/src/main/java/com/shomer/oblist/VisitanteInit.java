package com.shomer.oblist;

import java.util.Date;

public class VisitanteInit {

	public VisitanteInit() {}
	
	public VisitanteInit(int idvisitante, String nomvisitante, String apelvisitante, String codtipo, String numidentidad,
			String movilvisitante, String emailvisitante, String coddependencia, String codfuncionario, String codarl, String codrh,
			String codobservavis, String codaparatos, Date fechavisitante, String notas, Date fechasalida) {

		this.idvisitante = idvisitante;
		this.nomvisitante = nomvisitante;
		this.apelvisitante = apelvisitante;
		this.codtipo = codtipo;
		this.numidentidad = numidentidad;
		this.movilvisitante = movilvisitante;
		this.emailvisitante = emailvisitante;
		this.coddependencia = coddependencia;
		this.codfuncionario = codfuncionario;
		this.codarl = codarl;
		this.codrh = codrh;
		this.codobservavis = codobservavis;
		this.codaparatos = codaparatos;
		this.fechavisitante = fechavisitante;
		this.notas = notas;
		this.fechasalida = fechasalida;
	}
	
	public VisitanteInit(String nomvisitante, String apelvisitante, String codtipo, String numidentidad,
			String movilvisitante, String emailvisitante, String coddependencia, String codfuncionario, String codarl, String codrh,
			String codobservavis, String codaparatos, Date fechavisitante, String notas, Date fechasalida) {

		this.nomvisitante = nomvisitante;
		this.apelvisitante = apelvisitante;
		this.codtipo = codtipo;
		this.numidentidad = numidentidad;
		this.movilvisitante = movilvisitante;
		this.emailvisitante = emailvisitante;
		this.coddependencia = coddependencia;
		this.codfuncionario = codfuncionario;
		this.codarl = codarl;
		this.codrh = codrh;
		this.codobservavis = codobservavis;
		this.codaparatos = codaparatos;
		this.fechavisitante = fechavisitante;
		this.notas = notas;
		this.fechasalida = fechasalida;
	}

	
	public int getIdvisitante() {
		return idvisitante;
	}

	public void setIdvisitante(int idvisitante) {
		this.idvisitante = idvisitante;
	}

	public String getNomvisitante() {
		return nomvisitante;
	}

	public void setNomvisitante(String nomvisitante) {
		this.nomvisitante = nomvisitante;
	}

	public String getApelvisitante() {
		return apelvisitante;
	}

	public void setApelvisitante(String apelvisitante) {
		this.apelvisitante = apelvisitante;
	}

	public String getCodtipo() {
		return codtipo;
	}

	public void setCodtipo(String codtipo) {
		this.codtipo = codtipo;
	}

	public String getNumidentidad() {
		return numidentidad;
	}

	public void setNumidentidad(String numidentidad) {
		this.numidentidad = numidentidad;
	}

	public String getMovilvisitante() {
		return movilvisitante;
	}

	public void setMovilvisitante(String movilvisitante) {
		this.movilvisitante = movilvisitante;
	}

	public String getEmailvisitante() {
		return emailvisitante;
	}

	public void setEmailvisitante(String emailvisitante) {
		this.emailvisitante = emailvisitante;
	}

	public String getCoddependencia() {
		return coddependencia;
	}

	public void setCoddependencia(String coddependencia) {
		this.coddependencia = coddependencia;
	}

	public String getCodfuncionario() {
		return codfuncionario;
	}

	public void setCodfuncionario(String codfuncionario) {
		this.codfuncionario = codfuncionario;
	}

	public String getCodarl() {
		return codarl;
	}

	public void setCodarl(String codarl) {
		this.codarl = codarl;
	}

	public String getCodrh() {
		return codrh;
	}

	public void setCodrh(String codrh) {
		this.codrh = codrh;
	}

	public String getCodobservavis() {
		return codobservavis;
	}

	public void setCodobservavis(String codobservavis) {
		this.codobservavis = codobservavis;
	}

	public String getCodaparatos() {
		return codaparatos;
	}

	public void setCodaparatos(String codaparatos) {
		this.codaparatos = codaparatos;
	}

	public Date getFechavisitante() {
		return fechavisitante;
	}

	public void setFechavisitante(Date fechavisitante) {
		this.fechavisitante = fechavisitante;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Date getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}

	
	
	@Override
	public String toString() {
		return "VisitanteInit [idvisitante=" + idvisitante + ", nomvisitante=" + nomvisitante + ", apelvisitante="
				+ apelvisitante + ", codtipo=" + codtipo + ", numidentidad=" + numidentidad + ", movilvisitante="
				+ movilvisitante + ", emailvisitante=" + emailvisitante + ", coddependencia=" + coddependencia
				+ ", codfuncionario=" + codfuncionario + ", codarl=" + codarl + ", codrh=" + codrh + ", codobservavis="
				+ codobservavis + ", codaparatos=" + codaparatos + ", fechavisitante=" + fechavisitante + ", notas="
				+ notas + ", fechasalida=" + fechasalida + "]";
	}



	private int idvisitante;
	private String nomvisitante;
	private String apelvisitante;
	private String codtipo;
	private String numidentidad;
	private String movilvisitante;
	private String emailvisitante;
	private String coddependencia;
	private String codfuncionario;
	private String codarl;
	private String codrh;
	private String codobservavis;
	private String codaparatos;
	private Date fechavisitante;
	private String notas;
	private Date fechasalida;

}
