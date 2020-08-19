package com.mediscreen;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mediscreen.controller.RapportController;
import com.mediscreen.service.RapportService;

@WebMvcTest(RapportController.class)
@ExtendWith(SpringExtension.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	RapportService rapportService;

	@Test
	public void getRapportTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/rapport/getRapport/1")).andDo(print())
				.andExpect(status().isOk());
	}

}
