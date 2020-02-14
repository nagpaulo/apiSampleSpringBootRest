package br.com.projeto.apisamplerest.security.model.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.apisamplerest.security.model.entities.Permissao;

@Transactional
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
