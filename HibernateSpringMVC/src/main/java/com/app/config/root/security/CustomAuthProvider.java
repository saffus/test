package com.app.config.root.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomAuthProvider implements AuthenticationProvider {

	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	SCryptPasswordEncoder sCryptPasswordEncoder;
	
	@Autowired
	PasswordEncoder noOpPasswordEncoder;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userName = authentication.getName();
		String password  = authentication.getCredentials().toString();
		
		CustomUserDetails user = customUserDetailsService.loadUserByUsername(userName);
		
		switch(user.getUser().getAlgorithm()){
		
		case BCRYPT:
			return checkPassword(user, password, bCryptPasswordEncoder);
			
		case SCRYPT :
			return checkPassword(user, password, bCryptPasswordEncoder);
			
		case NOOP :
			return checkPassword(user, password, noOpPasswordEncoder);
			
	
			
		}
		
		throw new BadCredentialsException("Bad credentials");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return  UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
	private Authentication checkPassword(CustomUserDetails user, String rawPassword, PasswordEncoder encoder) {
		
		if (encoder.matches(rawPassword, user.getPassword())) {
			return new UsernamePasswordAuthenticationToken( user.getUsername(), user.getPassword(), user.getAuthorities()); 
		}
		else {
				throw new BadCredentialsException("Bad credentials");
		}
	}
}
