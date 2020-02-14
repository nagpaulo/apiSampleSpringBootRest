package br.com.projeto.apisamplerest.security.services;

import java.util.List;
import java.util.Optional;

import br.com.projeto.apisamplerest.security.model.entities.Permissao;

public interface PermissaoService {
	
	Optional<List<Permissao>> buscarPermissaoPorPerfil(String role);
}
