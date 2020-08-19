package com.mediscreen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mediscreen.model.Gender;
import com.mediscreen.model.Note;
import com.mediscreen.model.Patient;
import com.mediscreen.proxies.NoteProxy;
import com.mediscreen.proxies.PatientProxy;
import com.mediscreen.service.RapportService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ServiceTest {

	@Autowired
	RapportService rapportService;

	@MockBean
	PatientProxy patientProxy;

	@MockBean
	NoteProxy noteProxy;

	@Test
	public void getRapportTest() throws ParseException {
		Patient patient = new Patient("test12", "familyNane", LocalDate.of(2000, 1, 8), Gender.M, "150 street",
				"120-120-120");
		Mockito.when(patientProxy.showPatient(1)).thenReturn(patient);
		Note note1 = new Note(50, "note test", LocalDate.now());
		Note note2 = new Note(50, "note test", LocalDate.now());
		List<Note> notes = new ArrayList<>();
		notes.add(note2);
		notes.add(note1);
		Mockito.when(noteProxy.listNotes(1)).thenReturn(notes);

		String rapport = rapportService.getRapport(1);
		assertEquals(rapport, "None");
	};

}
