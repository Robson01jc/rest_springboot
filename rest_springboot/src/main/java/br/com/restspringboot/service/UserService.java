package br.com.restspringboot.service;

import br.com.restspringboot.model.User;

public interface UserService {
	User save(User user);

	User findByEmail(String email);
}
