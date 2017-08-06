package br.com.restspringboot.service.impl;


import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restspringboot.model.Usuario;
import br.com.restspringboot.repository.RoleRepository;
import br.com.restspringboot.repository.UserRepository;
import br.com.restspringboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	/*@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;*/

	@Override
	public void save(Usuario user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setListPerfil(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
		
		/*Usuario user = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Perfil role : user.getListPerfil()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);*/
	}

	@Override
	public Usuario findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
