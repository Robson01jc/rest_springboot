package br.com.restspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.restspringboot.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User save(User user);

	User findByEmail(String email);
}