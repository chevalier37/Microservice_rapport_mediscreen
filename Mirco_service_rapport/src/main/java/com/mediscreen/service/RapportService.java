package com.mediscreen.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.age.Age;
import com.mediscreen.model.Gender;
import com.mediscreen.model.Note;
import com.mediscreen.model.Patient;
import com.mediscreen.proxies.NoteProxy;
import com.mediscreen.proxies.PatientProxy;

@Service
public class RapportService {

	@Autowired
	PatientProxy patientProxy;

	@Autowired
	NoteProxy noteProxy;

	public String getRapport(int patientId) throws ParseException {
		Patient patient = patientProxy.showPatient(patientId);
		long nbrDéclencheurs = nbrDeclencheur(patientId);
		int age = Age.getAge(patient.getDateOfBirth());
		return diabete(nbrDéclencheurs, age, patient);
	}

	private String diabete(long nbrDéclencheurs, int age, Patient patient) {

		Gender gender = patient.getGender();

		if (nbrDéclencheurs >= 8 && age > 30) {
			return "Early onset";
		}

		if (nbrDéclencheurs >= 6 && age > 30) {
			return "In Danger";
		}

		if (gender.equals("H") && nbrDéclencheurs >= 5 && age < 30) {
			return "Early onset";
		}

		if (gender.equals("F") && nbrDéclencheurs >= 7 && age < 30) {
			return "Early onset";
		}

		if (gender.equals("H") && nbrDéclencheurs >= 3 && age < 30) {
			return "In Danger";
		}

		if (gender.equals("F") && nbrDéclencheurs >= 4 && age < 30) {
			return "In Danger";
		}

		if (nbrDéclencheurs >= 2 && age >= 30) {
			return "Borderline";
		}

		if (nbrDéclencheurs == 0) {
			return "None";
		}

		return "None";
	}

	private long nbrDeclencheur(int patientId) {
		List<Note> notes = noteProxy.listNotes(patientId);
		ArrayList<String> déclencheurs = new ArrayList();
		déclencheurs.add("hémoglobine a1c");
		déclencheurs.add("microalbumine");
		déclencheurs.add("taille");
		déclencheurs.add("poids");
		déclencheurs.add("fumeur");
		déclencheurs.add("anormal");
		déclencheurs.add("cholestérol");
		déclencheurs.add("vertige");
		déclencheurs.add("rechute");
		déclencheurs.add("réaction");
		déclencheurs.add("anticorps");

		long nbrDéclencheurs = 0;
		for (Note note : notes) {
			long i = déclencheurs.stream().filter(s -> note.getNote().toLowerCase().contains(s)).count();
			nbrDéclencheurs = nbrDéclencheurs + i;
		}

		return nbrDéclencheurs;
	}

}
