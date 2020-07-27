package com.azienda.esercizioJpa.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.esercizioJpa.model.ContoCorrente;

public class ContoCorrenteDao implements DaoInterface<ContoCorrente> {

	private EntityManager manager = null;

	public ContoCorrenteDao() {
		this(null);
	}

	public ContoCorrenteDao(EntityManager entityManager) {
		setManager(entityManager);
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void create(ContoCorrente obj) {
		manager.persist(obj);
	}

	@Override
	public List<ContoCorrente> retrieve() {
		List<ContoCorrente> listaConti = manager.createQuery("from ContoCorrente",ContoCorrente.class).getResultList();
		return listaConti;
	}

	@Override
	public void update(ContoCorrente obj) {
		manager.persist(obj);
	}

	@Override
	public void delete(ContoCorrente obj) {
		manager.remove(obj);
	}

}
