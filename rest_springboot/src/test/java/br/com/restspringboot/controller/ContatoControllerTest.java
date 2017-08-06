package br.com.restspringboot.controller;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.restspringboot.model.Contato;
import br.com.restspringboot.service.ContatoService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContatoController.class, secure = false)
public class ContatoControllerTest {

	@Autowired private MockMvc mockMvc;

	@MockBean private ContatoService contatoService;
	
	Contato mockContato = new Contato(1L, "teste", "teste@gmail.com", "teste", 12L, "teste", new Date(1488942000000L), true);

	String exampleContatoJson = "{\"id\":1,\"nome\":\"teste\",\"email\":\"teste@gmail.com\",\"motivo\":\"teste\",\"idDestinatarioSistema\":12,\"mensagem\":\"teste\",\"dataHoraCadastro\":1488942000000,\"ativo\":true}";

	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				contatoService.findById(Mockito.anyLong())).thenReturn(mockContato);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/contatos/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:1,nome:teste,email:teste@gmail.com,motivo:teste,idDestinatarioSistema:12,mensagem:teste,dataHoraCadastro:1488942000000,ativo:true}}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	@Test
	public void createStudentCourse() throws Exception {
		Contato mockCourse = new Contato(1L, "teste", "teste@gmail.com", "teste", 12L, "teste", new Date(1488942000000L), true);

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(
				contatoService.save(Mockito.any(Contato.class))).thenReturn(mockCourse);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/contatos")
				.accept(MediaType.APPLICATION_JSON).content(exampleContatoJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		/*assertEquals("http://localhost/students/Student1/courses/1",
				response.getHeader(HttpHeaders.LOCATION));*/

	}

}