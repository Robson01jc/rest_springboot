package br.com.restspringboot.model;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "perfil")
public class Perfil implements GrantedAuthority {

	private static final long serialVersionUID = -6804674304231182480L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToMany(mappedBy = "listPerfil")
	private Set<Usuario> listUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(Set<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

	@Override
	public String getAuthority() {
		return name.toString();
	}
}