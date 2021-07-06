package com.app.config.root.security;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.config.entity.User;
import com.app.config.repo.UserRepo;
import com.app.config.root.security.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Supplier<UsernameNotFoundException> nameNotFoundException = 
							() -> new UsernameNotFoundException("UserNot found");
							
		User user = userRepo.getUser(username)
						.orElseThrow(nameNotFoundException);
		
		return new CustomUserDetails(user);
	}

}
