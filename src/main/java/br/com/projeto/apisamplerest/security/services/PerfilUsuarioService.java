package br.com.projeto.apisamplerest.security.services;

import java.util.Optional;

import br.com.projeto.apisamplerest.security.model.entities.PerfilUsuario;

public interface PerfilUsuarioService {
	Optional<PerfilUsuario> buscarPorEmailOuLogin(String username);
}
