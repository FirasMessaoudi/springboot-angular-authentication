package com.example.test.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.test.model.Role;
import com.example.test.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrincipal implements UserDetails {

	private Long id;

	
	private String username;
	
	@JsonIgnore
	private String email;

	@JsonIgnore
	private String password;



	private List<Role> roles;

	public UserPrincipal(Long id,  String username, String email,
			String password,  List<Role> roles) {
		this.id = id;
		
		this.username = username;
		this.email = email;
		this.password = password;
		
		this.roles = roles;
		
		
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static UserPrincipal create(User user) {
		
		return new UserPrincipal(user.getId(), 
				user.getUsername(), user.getEmail(), user.getPassword(),  user.getRoles());
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	

	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object otherUser) {
		if(otherUser == null) return false;
		else if (!(otherUser instanceof UserDetails)) return false;
		else return (otherUser.hashCode() == hashCode());
	}

	@Override
	public int hashCode() {

		return this.username.hashCode();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles.stream().collect(Collectors.toList());
	}

	
}
