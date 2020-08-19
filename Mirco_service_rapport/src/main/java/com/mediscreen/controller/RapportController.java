package com.mediscreen.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen.service.RapportService;

@RestController
@RequestMapping("/rapport")
public class RapportController {

	@Autowired
	RapportService rapportService;

	@GetMapping("/getRapport/{patientId}")
	public String getRapport(@PathVariable("patientId") int patientId) throws ParseException {
		return rapportService.getRapport(patientId);
	}

}
