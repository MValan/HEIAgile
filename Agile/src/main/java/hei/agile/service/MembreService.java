package hei.agile.service;

import java.util.List;

import hei.agile.entity.Membre;

public interface MembreService {

	public void saveMembre(Membre membre);
	
	public List<Membre> findAll();
}
