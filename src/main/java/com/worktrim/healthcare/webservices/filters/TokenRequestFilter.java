package com.worktrim.healthcare.webservices.filters;



import com.worktrim.healthcare.webservices.config.TokenUtil;
import com.worktrim.healthcare.webservices.service.AppUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class TokenRequestFilter extends OncePerRequestFilter {

	@Autowired
	private TokenUtil jwtTokenUtil;
    @Autowired
	private AppUserDetailsService detailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		//boolean requestHasJWT =  requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ") ? true : false;

		/*************************************************************************
		 * If the request is not for first time login, and the request 
		 * doesn't have a token, send the user to re-authentication controller.
		 * That controller will return data that indicates the user needs to be 
		 * authenticated before they can access this resource
		 **************************************************************************/

		//if(!requestHasJWT && !request.getRequestURI().contains("/auth/userLogin") && !request.getRequestURI().contains("swagger-ui")) {

		//logger.info("request contains the following URI ---> " + request.getRequestURI());
		//request.getRequestDispatcher("/auth/updateUserLogin").forward(request, response);
		//}


		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {

			jwtToken = requestTokenHeader.substring(7);

			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {

				/*************************************************************************
				 * If the token is not valid, send the user to re-auth controller.
				 * That controller will return data that indicates the user needs to be 
				 * re-authenticated. The user will then be forwarded to the login 
				 * controller without passing any authentication type in the request header
				 * (by the client side script).
				 * The absence of "authorization" bearer token in the request will force
				 * the creation of a new token.
				 **************************************************************************/

				logger.warn("JWT Token is not valid");
				request.getRequestDispatcher("/auth/updateUserLogin").forward(request, response);

			} catch (ExpiredJwtException ex) {

				/*************************************************************************
				 * If the token has expired, send the user to re-auth controller.
				 * That controller will return data that indicates the user needs to be 
				 * re-authenticated. The user will then be forwarded to the login 
				 * controller without passing any authentication type in the request header.
				 * (by the client side script)
				 * The absence of "authorization" bearer token in the request will force
				 * the creation of a new token.
				 **************************************************************************/

				logger.info("JWT Token has expired");
				request.getRequestDispatcher("/auth/updateUserLogin").forward(request, response);

			}



			/* Do this work only if request has a token*/

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				boolean tokenValid = jwtTokenUtil.isTokenValid(jwtToken);

				if (tokenValid) {

					UserDetails userDetails = detailsService.loadUserByUsername(jwtToken);
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
		}



		chain.doFilter(request, response);
	}
}
