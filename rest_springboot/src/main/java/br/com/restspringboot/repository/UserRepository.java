package br.com.restspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restspringboot.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
	Usuario findByUsername(String username);
}