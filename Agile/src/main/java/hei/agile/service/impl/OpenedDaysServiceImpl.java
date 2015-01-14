package hei.agile.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.google.gson.Gson;

import hei.agile.dao.ClosedDaysDAO;
import hei.agile.dao.OpenedDaysDAO;
import hei.agile.entity.ClosedDays;
import hei.agile.entity.OpenedDays;
import hei.agile.service.OpenedDaysService;


@Named
@Transactional
public class OpenedDaysServiceImpl implements OpenedDaysService {

	@Inject
	private OpenedDaysDAO openedDaysDAO;
	
	@Inject
	private ClosedDaysDAO closedDaysDAO;

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
	
	@Override
	public String generateScriptClosedDays() {
		List<ClosedDays> allClosedDays = closedDaysDAO.findAll();
		String script = "<script>$('#from-input').multiDatesPicker({altField: '#datepicker',firstDay: 1,closeText: 'Fermer',prevText: 'Précédent',nextText: 'Suivant',currentText: 'Aujourdhui',monthNames: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],monthNamesShort: ['Janv.', 'Févr.', 'Mars', 'Avril', 'Mai', 'Juin', 'Juil.', 'Août', 'Sept.', 'Oct.', 'Nov.', 'Déc.'],dayNames: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'],dayNamesShort: ['Dim.', 'Lun.', 'Mar.', 'Mer.', 'Jeu.', 'Ven.', 'Sam.'],dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],weekHeader: 'Sem.'";
		if(!allClosedDays.isEmpty()){
			script += ",addDates: [";
			for (ClosedDays closedDays : allClosedDays) {
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				String theDate = df.format(closedDays.getDay());
				script += "'"+ theDate +"',";
			}
			script += "]";
		}
		script += "});</script>";
		return script;
	}
	
	@Override
	public String generateHtmlClosedDaysTable() {
		List<ClosedDays> allDays = closedDaysDAO.findAll();
		String html = "<table class='table'><thead><tr><th>Jour(s) ferm&eacute;</th></tr></thead><tbody id='insideClosedHtmlTable'>";
		
		for (ClosedDays closedDays : allDays) {
			html += "<tr><td>"+ closedDays.getDay() +"</td></tr>";
		}
		
		html +="</tbody></table>";
		
		return html;
	}
	
	public void updateOpenTime(String fromHour, String toHour, String day){
		openedDaysDAO.updateOpenTime(fromHour, toHour, day);
	}

	@Override
	public boolean isAnOpenedDay(Integer day) {
		
		List<OpenedDays> allOpenedDays = openedDaysDAO.findAll();
		List<Integer> openedDaysInteger  = new ArrayList<Integer>();
		
		if(!(allOpenedDays.isEmpty())){
		
			for (OpenedDays openedDays : allOpenedDays) {
				
				switch (openedDays.getDay()) {
				case "lundi":
					openedDaysInteger.add(Calendar.MONDAY);
					break;
				case "mardi":
					openedDaysInteger.add(Calendar.TUESDAY);
					break;
				case "mercredi":
					openedDaysInteger.add(Calendar.WEDNESDAY);
					break;
				case "jeudi":
					openedDaysInteger.add(Calendar.THURSDAY);
					break;
				case "vendredi":
					openedDaysInteger.add(Calendar.FRIDAY);
					break;
				case "samedi":
					openedDaysInteger.add(Calendar.SATURDAY);
					break;
				case "dimanche":
					openedDaysInteger.add(Calendar.SUNDAY);
					break;
				}
			}
			
			for (Integer dayOfWeek : openedDaysInteger) {
				
				if(day == dayOfWeek){
					
					return true;
				}
			}
		}
		else{
			
			return true; //on concidere que l'on est ouvert tous les jours de la semaine si rien n'est specifie
		}
		return false;
	}
	
}
