package br.com.projeto.apisamplerest.security.services.impl;


import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto.apisamplerest.mapper.UsuarioMapper;
import br.com.projeto.apisamplerest.security.exception.RegraNegocioException;
import br.com.projeto.apisamplerest.security.model.entities.Usuario;
import br.com.projeto.apisamplerest.security.model.repositories.UsuarioRepository;
import br.com.projeto.apisamplerest.security.services.UsuarioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper usuarioMapper;
	
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

	@Override
	public void validarPorEmail(String email) {
		boolean valida = this.usuarioRepository.existsByEmail(email);
		if(valida) {
			throw new RegraNegocioException("Já existe um usuario cadastrado com este email");
		}
	}

	@Override
	public void validarPorLogin(String login) {
		boolean valida = this.usuarioRepository.existsByLogin(login);
		if(valida) {
			throw new RegraNegocioException("Já existe um usuario cadastrado com este login");
		}
		
	}	
	
}