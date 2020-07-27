package com.azienda.esercizioJpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ContoCorrente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_conto_corrente;

	private String numeroConto;
	private Float saldo;

	@ManyToOne 
	@JoinColumn(name = "banca")
	private Banca banca = null;

	@ManyToMany(mappedBy = "conti")
	private List<Persona> persone = new ArrayList<Persona>();

	public ContoCorrente(String numeroConto, Float saldo) {
		this.numeroConto = numeroConto;
		this.saldo = saldo;
	}
	
	public ContoCorrente() {
		
	}

	public Integer getId_conto_corrente() {
		return id_conto_corrente;
	}

	public void setId_conto_corrente(Integer id_conto_corrente) {
		this.id_conto_corrente = id_conto_corrente;
	}

	public String getNumeroConto() {
		return numeroConto;
	}

	public void setNumeroConto(String numeroConto) {
		this.numeroConto = numeroConto;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public Banca getBanca() {
		return banca;
	}

	public void setBanca(Banca banca) {
		this.banca = banca;
	}

	public List<Persona> getPersone() {
		return persone;
	}

	public void setPersone(List<Persona> persone) {
		this.persone = persone;
	}

}
