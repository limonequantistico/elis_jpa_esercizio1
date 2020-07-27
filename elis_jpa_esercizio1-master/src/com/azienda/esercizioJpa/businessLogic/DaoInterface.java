package com.azienda.esercizioJpa.businessLogic;

import java.util.List;

public interface DaoInterface<T> {
	
	public void create(T obj);
	public List<T> retrieve();
	public void update(T obj);
	public void delete(T obj);
	
}
