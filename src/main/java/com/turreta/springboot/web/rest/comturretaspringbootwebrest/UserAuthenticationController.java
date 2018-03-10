package com.turreta.springboot.web.rest.comturretaspringbootwebrest;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/public/authenticate")
public class UserAuthenticationController
{
	private final Logger LOGGER = Logger.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AuthenticationResponseDTO> authenticationRequest(
			@RequestBody AuthenticationRequestDTO authenticationRequest)
	{
		// Delegate processing to some service to authenticate user


		// This log will not be available in the console log
		LOGGER.info(authenticationRequest.getUsername() + "|" + authenticationRequest.getPassword());

		AuthenticationResponseDTO dto = new AuthenticationResponseDTO();
		dto.setToken(UUID.randomUUID().toString());
		return ResponseEntity.ok(dto);
	}
}
