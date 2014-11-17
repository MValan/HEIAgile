package hei.agile.controller;

import hei.agile.service.MembreService;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.bind.annotation.RequestMapping;

@Named
@RequestMapping("/")
public class MembreController {

	@Inject
	private MembreService membreService;

}
