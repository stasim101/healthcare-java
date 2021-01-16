package com.worktrim.healthcare.webservices.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.worktrim.healthcare.webservices.config.TokenUtil;
import com.worktrim.healthcare.webservices.model.TokenRequest;
import com.worktrim.healthcare.webservices.model.TokenResponse;
import com.worktrim.healthcare.webservices.service.AppUserDetailsService;

@RestController
public class UserValidationController {

	static final Logger logger = LoggerFactory.getLogger(UserValidationController.class);

	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AppUserDetailsService appUserDetailsService;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> authorization(@RequestBody TokenRequest tokenRequest, HttpServletRequest request)
			throws Exception {

		String token = null;
		final String requestTokenHeader = request.getHeader("Authorization");
		authenticate(tokenRequest.getUsername(), tokenRequest.getPassword());
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer "))
			token = requestTokenHeader.substring(7);
		return ResponseEntity.ok(new TokenResponse(token));
	}
	
	

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
