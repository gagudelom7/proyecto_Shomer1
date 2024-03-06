package com.shomer.oblist;

import java.math.BigDecimal;
import java.util.Date;

public class MensajeriaInit {

public MensajeriaInit() {}
	
	public MensajeriaInit(int idmensajeria, String codmensajeria, BigDecimal cantidad, Date fechallegada, String codfuncionario,
			String remitente, String codempremensa, String codestadomensa, String codobservaciones, Date fechaentrega, String notasmensajeria) {
		
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
	
	public MensajeriaInit(String codmensajeria, BigDecimal cantidad, Date fechallegada, String codfuncionario,
			String remitente, String codempremensa, String codestadomensa, String codobservaciones, Date fechaentrega, String notasmensajeria) {
		
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
	
	
	
	public int getIdmensajeria() {
		return idmensajeria;
	}

	public void setIdmensajeria(int idmensajeria) {
		this.idmensajeria = idmensajeria;
	}

	public String getCodmensajeria() {
		return codmensajeria;
	}

	public void setCodmensajeria(String codmensajeria) {
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

	public String getCodfuncionario() {
		return codfuncionario;
	}

	public void setCodfuncionario(String codfuncionario) {
		this.codfuncionario = codfuncionario;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getCodempremensa() {
		return codempremensa;
	}

	public void setCodempremensa(String codempremensa) {
		this.codempremensa = codempremensa;
	}

	public String getCodestadomensa() {
		return codestadomensa;
	}

	public void setCodestadomensa(String codestadomensa) {
		this.codestadomensa = codestadomensa;
	}

	public String getCodobservaciones() {
		return codobservaciones;
	}

	public void setCodobservaciones(String codobservaciones) {
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
		return "MensajeriaInit [idmensajeria=" + idmensajeria + ", codmensajeria=" + codmensajeria + ", cantidad="
				+ cantidad + ", fechallegada=" + fechallegada + ", codfuncionario=" + codfuncionario + ", remitente="
				+ remitente + ", codempremensa=" + codempremensa + ", codestadomensa=" + codestadomensa
				+ ", codobservaciones=" + codobservaciones + ", fechaentrega=" + fechaentrega + ", notasmensajeria="
				+ notasmensajeria + "]";
	}



	private int idmensajeria;
	private String codmensajeria;
	private BigDecimal cantidad;
	private Date fechallegada;
	private String codfuncionario;
	private String remitente;
	private String codempremensa;
	private String codestadomensa;
	private String codobservaciones;
	private Date fechaentrega;
	private String notasmensajeria;
}
