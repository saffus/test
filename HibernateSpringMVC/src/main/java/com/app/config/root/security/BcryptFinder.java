package com.app.config.root.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptFinder {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
		System.out.println(pass.encode("admin"));
		

	}

}
