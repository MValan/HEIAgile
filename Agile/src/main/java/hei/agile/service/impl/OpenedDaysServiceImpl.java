package hei.agile.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.google.gson.Gson;

import hei.agile.dao.OpenedDaysDAO;
import hei.agile.entity.OpenedDays;
import hei.agile.service.OpenedDaysService;


@Named
@Transactional
public class OpenedDaysServiceImpl implements OpenedDaysService {

	@Inject
	private OpenedDaysDAO openedDaysDAO;

	@Override
	public void saveOpenedDays(OpenedDays openedDay){
		List<OpenedDays> allDays = openedDaysDAO.findAll();
		boolean alreadyExist = false;
		for (OpenedDays openedDays : allDays) {
			if(openedDays.getDay().equals(openedDay.getDay())){
				alreadyExist = true;
			}
		}
		if(alreadyExist){
			openedDaysDAO.updateOpenTime(openedDay.getFromHour(), openedDay.getToHour(), openedDay.getDay());
		}else{
			openedDaysDAO.save(openedDay);
		}
	}
	
	@Override
	public String addNewDay(String day, String from, String to) {
		Gson gson = new Gson();
		
		List<OpenedDays> openedAllDays = new ArrayList<OpenedDays>();

		for (OpenedDays openedDays : openedDaysDAO.findAll()) {
			openedAllDays.add(new OpenedDays(openedDays.getDay(), openedDays.getFromHour(), openedDays.getToHour()));
		}
		
		return gson.toJson(openedAllDays);
	}

	@Override
	public String generateHtmlDaysTable() {
		List<OpenedDays> allDays = openedDaysDAO.findAll();
		String html = "<table class='table'><thead><tr><th>Jour</th><th>De</th><th>A</th></tr></thead><tbody id='insideHtmlTable'>";
		
		for (OpenedDays openedDays : allDays) {
			html += "<tr><td>"+ openedDays.getDay() +"</td><td>"+ openedDays.getFromHour() +"</td><td>"+ openedDays.getToHour() +"</td></tr>";
		}
		
		html +="</tbody></table>";
		
		return html;
	}
	
	public void updateOpenTime(String fromHour, String toHour, String day){
		openedDaysDAO.updateOpenTime(fromHour, toHour, day);
	}
	
}
