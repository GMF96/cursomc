package com.gustavo.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.gustavo.cursomc.security.UserSecurity;

public class UserService {

	public static UserSecurity authenticated() {
		try {
			return (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
