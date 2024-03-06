package com.shomer.dto;

import java.util.Date;

public class Visitante {

	public Visitante() {
		// TODO Auto-generated constructor stub
	
	}
	
		public Visitante(int idvisitante, String nomvisitante, String apelvisitante, int codtipo, String numidentidad,
			String movilvisitante, String emailvisitante, int coddependencia, int codfuncionario, int codarl, int codrh,
			int codobservavis, int codaparatos, Date fechavisitante, String notas, Date fechasalida) {

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
		
		public Visitante(String nomvisitante, String apelvisitante, int codtipo, String numidentidad,
				String movilvisitante, String emailvisitante, int coddependencia, int codfuncionario, int codarl,
				int codrh, int codobservavis, int codaparatos, Date fechavisitante, String notas, Date fechasalida) {
			
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

		public Visitante(String nomvisitante, String apelvisitante, int codtipo, String numidentidad,
				String movilvisitante, String emailvisitante, int coddependencia, int codfuncionario, int codarl,
				int codrh, int codobservavis, int codaparatos, Date fechavisitante, String notas) {
			
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

		public int getCodtipo() {
			return codtipo;
		}

		public void setCodtipo(int codtipo) {
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

		public int getCoddependencia() {
			return coddependencia;
		}

		public void setCoddependencia(int coddependencia) {
			this.coddependencia = coddependencia;
		}

		public int getCodfuncionario() {
			return codfuncionario;
		}

		public void setCodfuncionario(int codfuncionario) {
			this.codfuncionario = codfuncionario;
		}

		public int getCodarl() {
			return codarl;
		}

		public void setCodarl(int codarl) {
			this.codarl = codarl;
		}

		public int getCodrh() {
			return codrh;
		}

		public void setCodrh(int codrh) {
			this.codrh = codrh;
		}

		public int getCodobservavis() {
			return codobservavis;
		}

		public void setCodobservavis(int codobservavis) {
			this.codobservavis = codobservavis;
		}

		public int getCodaparatos() {
			return codaparatos;
		}

		public void setCodaparatos(int codaparatos) {
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
			return "Visitante [idvisitante=" + idvisitante + ", nomvisitante=" + nomvisitante + ", apelvisitante="
					+ apelvisitante + ", codtipo=" + codtipo + ", numidentidad=" + numidentidad + ", movilvisitante="
					+ movilvisitante + ", emailvisitante=" + emailvisitante + ", coddependencia=" + coddependencia
					+ ", codfuncionario=" + codfuncionario + ", codarl=" + codarl + ", codrh=" + codrh
					+ ", codobservavis=" + codobservavis + ", codaparatos=" + codaparatos + ", fechavisitante="
					+ fechavisitante + ", notas=" + notas + ", fechasalida=" + fechasalida + "]";
		}

		//Creamos variables encapsuladas de tipo Visitante

		private int idvisitante;
		private String nomvisitante;
		private String apelvisitante;
		private int codtipo;
		private String numidentidad;
		private String movilvisitante;
		private String emailvisitante;
		private int coddependencia;
		private int codfuncionario;
		private int codarl;
		private int codrh;
		private int codobservavis;
		private int codaparatos;
		private Date fechavisitante;
		private String notas;
		private Date fechasalida;

}
