package br.com.projeto.apisamplerest.security.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.apisamplerest.security.model.entities.Permissao;
import br.com.projeto.apisamplerest.security.model.repositories.PermissaoRepository;
import br.com.projeto.apisamplerest.security.services.PermissaoService;

@Service
public class PermissaoServiceImp implements PermissaoService{
	
	@Autowired
	private PermissaoRepository repository;

	@Override
	public Optional<List<Permissao>> buscarPermissaoPorPerfil(String role) {		
		return repository.buscarPermissaoPorPerfil(role);
	}

}
