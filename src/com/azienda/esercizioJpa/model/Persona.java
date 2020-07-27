package com.azienda.esercizioJpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_persona;

	private String nome;
	private String cognome;

	@ManyToMany
	@JoinTable(name = "Conti_Persone", joinColumns = @JoinColumn(name = "id_persona"), inverseJoinColumns = @JoinColumn(name = "id_conto_corrente"))
	private List<ContoCorrente> conti = new ArrayList<ContoCorrente>();

	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Persona() {
		
	}

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<ContoCorrente> getConti() {
		return conti;
	}

	public void setConti(List<ContoCorrente> conti) {
		this.conti = conti;
	}

}
