package com.azienda.esercizioJpa.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.esercizioJpa.model.Persona;

public class PersonaDao implements DaoInterface<Persona> {

	private EntityManager manager = null;

	public PersonaDao() {
		this(null);
	}

	public PersonaDao(EntityManager entityManager) {
		setManager(entityManager);
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public List<Persona> findByNomeAndCognome(String nome, String cognome) {
		List<Persona> result = manager.createQuery("select p from Persona p where p.nome = '" + nome + "' and cognome = '" + cognome + "'", Persona.class).getResultList();
		return result;
	}

	@Override
	public void create(Persona obj) {
		manager.persist(obj);
	}

	@Override
	public List<Persona> retrieve() {
		List<Persona> listaPersone = manager.createQuery("from Persona",Persona.class).getResultList();
		return listaPersone;
	}

	@Override
	public void update(Persona obj) {
		manager.persist(obj);
	}

	@Override
	public void delete(Persona obj) {
		manager.remove(obj);
	}

}
