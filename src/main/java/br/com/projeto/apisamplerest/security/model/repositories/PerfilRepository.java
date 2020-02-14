package br.com.projeto.apisamplerest.security.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.apisamplerest.security.model.entities.Perfil;

@Transactional
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
