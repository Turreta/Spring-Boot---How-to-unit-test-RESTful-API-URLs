package com.turreta.springboot.web.rest.comturretaspringbootwebrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserAuthenticationController.class)
public class UserAuthenticationControllerTest
{

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserAuthenticationController userAuthenticationController;

	@Test
	public void testSearchForTravelInsuranceProducts() throws Exception
	{

		ObjectMapper objectMapper = new ObjectMapper();
		AuthenticationRequestDTO authenticationRequestDTO  = new AuthenticationRequestDTO();
		authenticationRequestDTO.setUsername("awesome");
		authenticationRequestDTO.setPassword("awesome!password");

		String jsonInString = objectMapper.writeValueAsString(authenticationRequestDTO);

		mockMvc.perform(post("/api/public/authenticate")
				.contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isOk());
	}

}