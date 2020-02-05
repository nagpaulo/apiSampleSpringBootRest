package br.com.projeto.apisamplerest.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.apisamplerest.security.model.entities.PerfilUsuario;
import br.com.projeto.apisamplerest.security.model.repositories.PerfilUsuarioRepository;
import br.com.projeto.apisamplerest.security.services.PerfilUsuarioService;

@Service
public class PerfilUsuarioServiceImpl implements PerfilUsuarioService{
	
	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository;
	
	
	@Override
	public Optional<PerfilUsuario> buscarPorEmailOuLogin(String username) {
		return Optional.ofNullable(this.perfilUsuarioRepository.findByEmailOrLogin(username));
	}

}
