package com.totalizator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by home
 */
@Service
@Transactional
public class UserDetailsService implements IUserDetailsService {

	private final IUserService userService;

	@Autowired
	public UserDetailsService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		boolean userExists = userService.checkIfUserExists(login);
		if (userExists)
			return userService.findUserByUsername(login);
		else
			throw new UsernameNotFoundException("Not found");
	}
}
