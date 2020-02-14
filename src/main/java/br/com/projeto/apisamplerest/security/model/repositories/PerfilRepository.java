package br.com.projeto.apisamplerest.security.model.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.apisamplerest.security.model.entities.Perfil;

@Transactional
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
