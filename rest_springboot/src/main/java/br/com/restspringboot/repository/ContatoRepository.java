package br.com.restspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.restspringboot.model.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Long> {

}
