package com.worktrim.healthcare.webservices.service;

import com.worktrim.healthcare.webservices.config.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service("customUserDetailsServices")
public class AppUserDetailsService implements UserDetailsService {

	static final Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);
	@Autowired
	private TokenUtil jwtTokenUtil;

	@Override
	public UserDetails loadUserByUsername(String accessToken) throws UsernameNotFoundException {

		String ssoId =  jwtTokenUtil.getssoIdFromToken(accessToken);
		String username = jwtTokenUtil.getUsernameFromToken(accessToken);

		return new User(username, ssoId, getAuthorities(accessToken));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(String token) {
		List results =  jwtTokenUtil.getAuthoritiesFromToken(token);
		String authString = StringUtils.join(results, ',');
		List<GrantedAuthority> granted =  AuthorityUtils.commaSeparatedStringToAuthorityList(authString);
		return granted;
	}

}