package com.shomer.dto;


import java.math.BigDecimal;
import java.util.Date;


public class Mensajeria {

	public Mensajeria() {}
	
	public Mensajeria(int idmensajeria, int codmensajeria, BigDecimal cantidad, Date fechallegada, int codfuncionario,
			String remitente, int codempremensa, int codestadomensa, int codobservaciones, Date fechaentrega, String notasmensajeria) {
		
		this.idmensajeria = idmensajeria;
		this.codmensajeria = codmensajeria;
		this.cantidad = cantidad;
		this.fechallegada = fechallegada;
		this.codfuncionario = codfuncionario;
		this.remitente = remitente;
		this.codempremensa = codempremensa;
		this.codestadomensa = codestadomensa;
		this.codobservaciones = codobservaciones;
		this.fechaentrega = fechaentrega;
		this.notasmensajeria = notasmensajeria;
	}
	
	
	public Mensajeria(int codmensajeria, BigDecimal cantidad, Date fechallegada, int codfuncionario, String remitente,
			int codempremensa, int codestadomensa, int codobservaciones, Date fechaentrega, String notasmensajeria) {
		
		this.codmensajeria = codmensajeria;
		this.cantidad = cantidad;
		this.fechallegada = fechallegada;
		this.codfuncionario = codfuncionario;
		this.remitente = remitente;
		this.codempremensa = codempremensa;
		this.codestadomensa = codestadomensa;
		this.codobservaciones = codobservaciones;
		this.fechaentrega = fechaentrega;
		this.notasmensajeria = notasmensajeria;
	}
	
	public Mensajeria(int codmensajeria, BigDecimal cantidad, Date fechallegada, int codfuncionario, String remitente,
			int codempremensa, int codestadomensa, int codobservaciones, String notasmensajeria) {
		
		this.codmensajeria = codmensajeria;
		this.cantidad = cantidad;
		this.fechallegada = fechallegada;
		this.codfuncionario = codfuncionario;
		this.remitente = remitente;
		this.codempremensa = codempremensa;
		this.codestadomensa = codestadomensa;
		this.codobservaciones = codobservaciones;
		this.notasmensajeria = notasmensajeria;
	}
	

	public int getIdmensajeria() {
		return idmensajeria;
	}


	public void setIdmensajeria(int idmensajeria) {
		this.idmensajeria = idmensajeria;
	}


	public int getCodmensajeria() {
		return codmensajeria;
	}


	public void setCodmensajeria(int codmensajeria) {
		this.codmensajeria = codmensajeria;
	}


	public BigDecimal getCantidad() {
		return cantidad;
	}


	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}


	public Date getFechallegada() {
		return fechallegada;
	}


	public void setFechallegada(Date fechallegada) {
		this.fechallegada = fechallegada;
	}


	public int getCodfuncionario() {
		return codfuncionario;
	}


	public void setCodfuncionario(int codfuncionario) {
		this.codfuncionario = codfuncionario;
	}


	public String getRemitente() {
		return remitente;
	}


	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}


	public int getCodempremensa() {
		return codempremensa;
	}


	public void setCodempremensa(int codempremensa) {
		this.codempremensa = codempremensa;
	}


	public int getCodestadomensa() {
		return codestadomensa;
	}


	public void setCodestadomensa(int codestadomensa) {
		this.codestadomensa = codestadomensa;
	}


	public int getCodobservaciones() {
		return codobservaciones;
	}


	public void setCodobservaciones(int codobservaciones) {
		this.codobservaciones = codobservaciones;
	}
	
	public Date getFechaentrega() {
		return fechaentrega;
	}


	public void setFechaentrega(Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	
	public String getNotasmensajeria() {
		return notasmensajeria;
	}


	public void setNotasmensajeria(String notasmensajeria) {
		this.notasmensajeria = notasmensajeria;
	}


	@Override
	public String toString() {
		return "Mensajeria [idmensajeria=" + idmensajeria + ", codmensajeria=" + codmensajeria + ", cantidad="
				+ cantidad + ", fechallegada=" + fechallegada + ", codfuncionario=" + codfuncionario + ", remitente="
				+ remitente + ", codempremensa=" + codempremensa + ", codestadomensa=" + codestadomensa
				+ ", codobservaciones=" + codobservaciones + ", fechaentrega=" + fechaentrega + ", notasmensajeria="
				+ notasmensajeria + "]";
	}

	
	//Creamos variables encapsuladas de tipo Mensajeria

	private int idmensajeria;
	private int codmensajeria;
	private BigDecimal cantidad;
	private Date fechallegada;
	private int codfuncionario;
	private String remitente;
	private int codempremensa;
	private int codestadomensa;
	private int codobservaciones;
	private Date fechaentrega;
	private String notasmensajeria;
	
}

