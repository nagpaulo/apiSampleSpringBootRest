package br.com.projeto.apisamplerest.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.projeto.apisamplerest.security.JwtUserFactory;
import br.com.projeto.apisamplerest.security.model.entities.PerfilUsuario;
import br.com.projeto.apisamplerest.security.services.PerfilUsuarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private PerfilUsuarioService perfilUsuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<PerfilUsuario> user = perfilUsuarioService.buscarPorEmailOuLogin(username);	
		
		if(user.isPresent()) {
			return JwtUserFactory.create(user.get());
		}
		
		throw new UsernameNotFoundException("Usuario não encontrado.");
	}

}
