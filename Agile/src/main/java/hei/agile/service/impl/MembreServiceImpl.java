package hei.agile.service.impl;

import java.util.List;

import javax.inject.Inject;

import hei.agile.dao.MembreDAO;
import hei.agile.entity.Membre;
import hei.agile.service.MembreService;

public class MembreServiceImpl implements MembreService {

	@Inject
	private MembreDAO membreDAO;
	
	@Override
	public void saveMembre(Membre membre) {
		membreDAO.save(membre);	
	}

	@Override
	public List<Membre> findAll() {
		List<Membre> membres = membreDAO.findAll();
		return membres;
	}
	
	

}
