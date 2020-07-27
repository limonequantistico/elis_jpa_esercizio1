package com.azienda.esercizioJpa.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.esercizioJpa.model.Banca;

public class BancaDao implements DaoInterface<Banca> {

	private EntityManager manager = null;

	public BancaDao() {
		this(null);
	}

	public BancaDao(EntityManager entityManager) {
		setManager(entityManager);
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void create(Banca obj) {
		manager.persist(obj);
	}

	@Override
	public List<Banca> retrieve() {
		List<Banca> listaBanche = manager.createQuery("from Banca",Banca.class).getResultList();
		return listaBanche;
	}

	@Override
	public void update(Banca obj) {
		manager.persist(obj);
	}

	@Override
	public void delete(Banca obj) {
		manager.remove(obj);
	}

}
