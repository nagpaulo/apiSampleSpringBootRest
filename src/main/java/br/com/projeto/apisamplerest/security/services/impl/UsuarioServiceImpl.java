package br.com.projeto.apisamplerest.security.services.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.apisamplerest.mapper.UsuarioMapper;
import br.com.projeto.apisamplerest.security.model.entities.Usuario;
import br.com.projeto.apisamplerest.security.model.repositories.UsuarioRepository;
import br.com.projeto.apisamplerest.security.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Override
	public Optional<Usuario> buscarPorEmail(String email) {
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}

	@Override
	public Optional<Usuario> findPorEmailMapper(String login) {
		return Optional.ofNullable(this.usuarioMapper.findByLogin(login));
	}

	@Override
	public Optional<Usuario> buscarPorEmailOuLogin(String username) {
		return Optional.ofNullable(this.usuarioRepository.findByEmailOrLogin(username));
	}	
	
}