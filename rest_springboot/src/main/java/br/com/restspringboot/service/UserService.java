package br.com.restspringboot.service;

import br.com.restspringboot.model.Usuario;

public interface UserService {
    void save(Usuario user);

    Usuario findByUsername(String username);
}
