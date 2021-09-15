package com.teste.mvp1;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@SpringBootTest
@DisplayName("Testing to DB")
@AutoConfigureMockMvc
class Mvp1ApplicationTests {

	private static final String URL_HOSPITAL = "/api/controllerhospital";
	private static final String URL_PACIENTE = "/api/controllerpaciente";
	private static final String URL_RECURSO = "/api/controllerrecurso";
	private static final String URL_TROCA = "/api/trocacontroller";

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup().build();
	}





}
