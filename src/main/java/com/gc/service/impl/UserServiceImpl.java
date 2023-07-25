package com.gc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gc.entity.User;
import com.gc.repository.UserRepository;
import com.gc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User getById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User add(User user) {
		user.setDateCreation(new Date());
		return userRepository.save(user);
	}

	@Override
	public User update(User user, Long id) {
		user.setId(id);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void delet(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("erreur delete");
		}
	}

	@Override
	public User getByPseudo(String pseudo) {
		return userRepository.findByPseudo(pseudo);
	}

}
