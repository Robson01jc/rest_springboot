package br.com.restspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.restspringboot.model.Contato;
import br.com.restspringboot.service.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoService service;

	@RequestMapping(method = RequestMethod.POST, value = "/contatos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> save(@RequestBody Contato contato) {
		return new ResponseEntity<Contato>(service.save(contato), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/contatos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Contato>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/contatos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> findById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/contatos/{id}")
	public ResponseEntity<Contato> delete(@PathVariable Long id) {
		Contato contato = service.findById(id);
		if (contato == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.delete(contato);
		return new ResponseEntity<Contato>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/contatos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> update(@RequestBody Contato contato) {
		return new ResponseEntity<Contato>(service.update(contato), HttpStatus.OK);
	}
}
