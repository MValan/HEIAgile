package hei.agile.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import hei.agile.dao.ClosedDaysDAO;
import hei.agile.entity.ClosedDays;
import hei.agile.service.ClosedDaysService;


@Named
@Transactional
public class ClosedDaysServiceImpl implements ClosedDaysService {

	@Inject
	private ClosedDaysDAO closedDaysDAO;

	@Override
	public void saveClosedDays(ClosedDays closedDay){
		//closedDaysDAO.deleteAll();
		//closedDaysDAO.save(closedDay);
		
		
		
		closedDaysDAO.save(closedDay);
	}
}
