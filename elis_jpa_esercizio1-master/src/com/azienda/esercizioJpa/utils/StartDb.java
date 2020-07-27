package com.azienda.esercizioJpa.utils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.azienda.esercizioJpa.businessLogic.BancaDao;
import com.azienda.esercizioJpa.businessLogic.BusinessLogic;
import com.azienda.esercizioJpa.businessLogic.ContoCorrenteDao;
import com.azienda.esercizioJpa.businessLogic.PersonaDao;
import com.azienda.esercizioJpa.model.Banca;
import com.azienda.esercizioJpa.model.ContoCorrente;
import com.azienda.esercizioJpa.model.Persona;

public class StartDb {

	public static void main(String[] args) {

		EntityManager entityManager = null;

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Paperino");
			entityManager = entityManagerFactory.createEntityManager(); // Creazione DB

			BancaDao bancaDao = new BancaDao(entityManager);
			ContoCorrenteDao contoCorrenteDao = new ContoCorrenteDao(entityManager);
			PersonaDao personaDao = new PersonaDao(entityManager);
			BusinessLogic businessLogic = new BusinessLogic(bancaDao, contoCorrenteDao, personaDao, entityManager);

			Persona p1 = new Persona("Ciccio", "Pasticcio");
			ContoCorrente cc1 = new ContoCorrente("123", 1000f);
			ContoCorrente cc2 = new ContoCorrente("456", 2000f);
			ContoCorrente cc3 = new ContoCorrente("789", 3000f);
			List<ContoCorrente> listaConti = new ArrayList<>();
			listaConti.add(cc1);
			listaConti.add(cc2);
			listaConti.add(cc3);
			Banca b1 = new Banca("Banca test 1");

			businessLogic.create(p1, listaConti, b1); // Scoppia(va) qui
			
			Persona p2 = new Persona("Mario", "Rossi");
			ContoCorrente cc4 = new ContoCorrente("321", 4000f);
			ContoCorrente cc5 = new ContoCorrente("654", 5000f);
			ContoCorrente cc6 = new ContoCorrente("987", 6000f);
			List<ContoCorrente> listaConti2 = new ArrayList<>();
			listaConti2.add(cc4);
			listaConti2.add(cc5);
			listaConti2.add(cc6);
			
			businessLogic.create(p2, listaConti2, b1); // E ora scoppia(va) qui
			
			// spostaFondi()
			businessLogic.spostaFondi("Ciccio", "Pasticcio", "Mario", "Rossi", 500f);
			
			// Reinserimento per vedere se spostaFondi() funziona
			businessLogic.create(p1, listaConti, b1);
			businessLogic.create(p2, listaConti2, b1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			System.exit(0);
		}
	}

}
