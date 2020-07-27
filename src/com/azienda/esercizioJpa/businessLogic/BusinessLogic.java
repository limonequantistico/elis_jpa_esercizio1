package com.azienda.esercizioJpa.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.esercizioJpa.model.Banca;
import com.azienda.esercizioJpa.model.ContoCorrente;
import com.azienda.esercizioJpa.model.Persona;

public class BusinessLogic {

	private BancaDao bancaDao = null;
	private ContoCorrenteDao contoCorrenteDao = null;
	private PersonaDao personaDao = null;
	private EntityManager entityManager = null;

	

	public BusinessLogic(BancaDao bancaDao, ContoCorrenteDao contoCorrenteDao, PersonaDao personaDao, EntityManager entityManager) {
		setEntityManager(entityManager);
		setBancaDao(bancaDao);
		setContoCorrenteDao(contoCorrenteDao);
		setPersonaDao(personaDao);
	}

	public void create(Persona persona, List<ContoCorrente> conti, Banca banca) { // Da rivedere
		entityManager.getTransaction().begin();
		try {
			
			banca.setListaConti(conti);
			bancaDao.create(banca);
			
			for (ContoCorrente contoCorrente : conti) {
				contoCorrenteDao.create(contoCorrente);
			}
			
			persona.setConti(conti);
			personaDao.create(persona);
			
			entityManager.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void spostaFondi(String nome1, String cognome1, String nome2, String cognome2, Float importo) {
		
		// Deve cercare su db due persone tramite nome e cognome, solo se le trove entrambe deve decrementare 
		// il saldo di tutti i conti della prima persona ed incrementare tutti quelli della seconda in base 
		// all'importo inserito, il tutto in modo transazionale
		
		
		
	}

	public BancaDao getBancaDao() {
		return bancaDao;
	}

	public void setBancaDao(BancaDao bancaDao) {
		this.bancaDao = bancaDao;
	}

	public ContoCorrenteDao getContoCorrenteDao() {
		return contoCorrenteDao;
	}

	public void setContoCorrenteDao(ContoCorrenteDao contoCorrenteDao) {
		this.contoCorrenteDao = contoCorrenteDao;
	}

	public PersonaDao getPersonaDao() {
		return personaDao;
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
