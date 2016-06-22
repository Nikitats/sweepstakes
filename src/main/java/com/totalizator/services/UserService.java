package com.totalizator.services;

import com.totalizator.dao.entities.Role;
import com.totalizator.dao.entities.User;
import com.totalizator.dao.repository.IRoleRepository;
import com.totalizator.dao.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by home
 */
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	public UserService(IUserRepository userRepository, IRoleRepository roleRepository) throws Exception {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	private final IUserRepository userRepository;
	private final IRoleRepository roleRepository;

	@Override
	@Transactional
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public User findUserByUsername(String username) {
		try {
			User user = userRepository.findByUsername(username);
			return user;
		}catch (Exception ex) {
			return null;
		}
	}

	@Override
	@Transactional
	public List<Role> findAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteUser(long id) {
		userRepository.delete(id);
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public User saveCurrentUserWithDetailsUpdate(User user) {
		User savedUser = userRepository.save(user);
		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser, savedUser.getPassword(), savedUser.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return savedUser;
	}

	@Override
	@Transactional
	public void changeUserPassword(String username, String currentPassword, String newPassword) throws Exception {
		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new Exception("");
		if (!user.getPassword().equals(currentPassword))
			throw new Exception("");
		user.setPassword(newPassword);
		userRepository.saveAndFlush(user);
	}

	@Override
	public boolean checkIfUserExists(String login) {
		return userRepository.checkIfUserExists(login);
	}
}
