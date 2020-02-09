package br.com.projeto.apisamplerest.security.services;

import java.util.Optional;

import br.com.projeto.apisamplerest.security.model.entities.Usuario;

public interface UsuarioService {

	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<Usuario> buscarPorEmail(String email);
	
	Optional<Usuario> findPorEmailMapper(String login);
	
	Optional<Usuario> buscarPorEmailOuLogin(String username);
	
	void validarPorEmail(String email);
	
	void validarPorLogin(String login);

}
