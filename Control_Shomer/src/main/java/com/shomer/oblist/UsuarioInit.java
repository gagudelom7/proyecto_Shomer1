package com.shomer.oblist;

import java.util.Date;

public class UsuarioInit {

public UsuarioInit() {}
	
	public UsuarioInit(int idusu, String nomusu, String apelusu, String usu, String contr, String emailusu, String movilusu,
			Date fech, String codperf, String codrh, String codarl) {
		
		this.idusu = idusu;
		this.nomusu = nomusu;
		this.apelusu = apelusu;
		this.usu = usu;
		this.contr = contr;
		this.emailusu = emailusu;
		this.movilusu = movilusu;
		this.fech = fech;
		this.codperf = codperf;
		this.codrh = codrh;
		this.codarl = codarl;
	}
	
	public UsuarioInit(String nomusu, String apelusu, String usu, String contr, String emailusu, String movilusu,
			Date fech, String codperf, String codrh, String codarl) {
		
		this.nomusu = nomusu;
		this.apelusu = apelusu;
		this.usu = usu;
		this.contr = contr;
		this.emailusu = emailusu;
		this.movilusu = movilusu;
		this.fech = fech;
		this.codperf = codperf;
		this.codrh = codrh;
		this.codarl = codarl;
	}
	
	
	public int getIdusu() {
		return idusu;
	}

	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}

	public String getNomusu() {
		return nomusu;
	}

	public void setNomusu(String nomusu) {
		this.nomusu = nomusu;
	}

	public String getApelusu() {
		return apelusu;
	}

	public void setApelusu(String apelusu) {
		this.apelusu = apelusu;
	}

	public String getUsu() {
		return usu;
	}

	public void setUsu(String usu) {
		this.usu = usu;
	}

	public String getContr() {
		return contr;
	}

	public void setContr(String contr) {
		this.contr = contr;
	}

	public String getEmailusu() {
		return emailusu;
	}

	public void setEmailusu(String emailusu) {
		this.emailusu = emailusu;
	}

	public String getMovilusu() {
		return movilusu;
	}

	public void setMovilusu(String movilusu) {
		this.movilusu = movilusu;
	}

	public Date getFech() {
		return fech;
	}

	public void setFech(Date fech) {
		this.fech = fech;
	}

	public String getCodperf() {
		return codperf;
	}

	public void setCodperf(String codperf) {
		this.codperf = codperf;
	}

	public String getCodrh() {
		return codrh;
	}

	public void setCodrh(String codrh) {
		this.codrh = codrh;
	}

	public String getCodarl() {
		return codarl;
	}

	public void setCodarl(String codarl) {
		this.codarl = codarl;
	}



	@Override
	public String toString() {
		return "UsuarioInit [idusu=" + idusu + ", nomusu=" + nomusu + ", apelusu=" + apelusu + ", usu=" + usu
				+ ", contr=" + contr + ", emailusu=" + emailusu + ", movilusu=" + movilusu + ", fech=" + fech
				+ ", codperf=" + codperf + ", codrh=" + codrh + ", codarl=" + codarl + "]";
	}



	private int idusu;
	private String nomusu;
	private String apelusu;
	private String usu;
	private String contr;
	private String emailusu;
	private String movilusu;
	private Date fech;
	private String codperf;
	private String codrh;
	private String codarl;
}
