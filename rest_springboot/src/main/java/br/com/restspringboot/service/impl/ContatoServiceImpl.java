package br.com.restspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restspringboot.model.Contato;
import br.com.restspringboot.repository.ContatoRepository;
import br.com.restspringboot.service.ContatoService;

@Service
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository repository;

	@Override
	public Contato save(Contato contato) {
		return repository.save(contato);
	}

	@Override
	public Iterable<Contato> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Contato contato) {
		repository.delete(contato);
	}

	@Override
	public Contato findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Contato update(Contato contato) {
		return repository.save(contato);
	}

}
