package com.gc.service;

import java.util.List;

import com.gc.entity.User;

public interface UserService {
	User getById(Long id);

	User add(User user);

	User update(User user, Long id);

	List<User> getAll();

	void delet(Long id);

	User getByPseudo(String pseudo);

}