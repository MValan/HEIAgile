package hei.agile.service;

import hei.agile.entity.OpenedDays;

public interface OpenedDaysService {

	public void saveOpenedDays(OpenedDays openedDay);
	
	public String addNewDay(String day, String from, String to);
	
	public String generateHtmlDaysTable();

	public String generateScriptClosedDays();

	public String generateHtmlClosedDaysTable();
	
	public boolean isAnOpenedDay(Integer day);
}