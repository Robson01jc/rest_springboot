package br.com.restspringboot.config;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.restspringboot.model.Usuario;
import br.com.restspringboot.service.UserService;

@Component
public class AuthProviderService implements AuthenticationProvider {

    @Autowired
    private UserService usuarioService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String login = auth.getName();
        String senha = auth.getCredentials().toString();

        // Defina suas regras para realizar a autenticação
        Usuario usuarioDB = new Usuario();

        if (usuarioDB != null) {
            if (usuarioAtivo(usuarioDB)) {
                Collection<? extends GrantedAuthority> authorities = usuarioDB.getListPerfil();
                return new UsernamePasswordAuthenticationToken(login, senha, authorities);
            } else {
                throw new BadCredentialsException("Este usuário está desativado.");
            }
        }

        throw new UsernameNotFoundException("Login e/ou Senha inválidos.");
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean usuarioAtivo(Usuario usuario) {
        /*if (usuario != null) {
            if (usuario.getStatus() == true) {
                return true;
            }
        }*/
        return false;
    }
}
