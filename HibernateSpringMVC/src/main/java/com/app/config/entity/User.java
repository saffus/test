package com.app.config.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.config.enums.EncryptionAlgorithm;

@Entity
@Table(name = "User",schema = "hibernate")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String username; 
	private String password; 
	
	
	
	public User() {}

	public User(String username, String password, EncryptionAlgorithm algorithm) {
		super();
		this.username = username;
		this.password = password;
		this.algorithm = algorithm;
	}

	@Enumerated(EnumType.STRING) 
	private EncryptionAlgorithm algorithm; 
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Authority> authorities;

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public EncryptionAlgorithm getAlgorithm() {
		return algorithm;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAlgorithm(EncryptionAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	
}
