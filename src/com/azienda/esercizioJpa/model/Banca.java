package com.azienda.esercizioJpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_banca;
	private String nome;

	@OneToMany(mappedBy = "banca")
	private List<ContoCorrente> listaConti = new ArrayList<ContoCorrente>();

	public Banca(String nome) {
		this.nome = nome;
	}
	
	public Banca() {
		
	}

	public Integer getId_banca() {
		return id_banca;
	}

	public void setId_banca(Integer id_banca) {
		this.id_banca = id_banca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ContoCorrente> getListaConti() {
		return listaConti;
	}

	public void setListaConti(List<ContoCorrente> listaConti) {
		this.listaConti = listaConti;
	}

}
