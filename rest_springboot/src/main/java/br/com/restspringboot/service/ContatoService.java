package br.com.restspringboot.service;

import br.com.restspringboot.model.Contato;

public interface ContatoService {

	public Contato save(Contato contato);

	public Iterable<Contato> findAll();

	public void delete(Contato contato);

	public Contato findById(Long id);

	public Contato update(Contato contato);

}
