package br.com.restspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restspringboot.model.Perfil;

public interface RoleRepository extends JpaRepository<Perfil, Long>{
}