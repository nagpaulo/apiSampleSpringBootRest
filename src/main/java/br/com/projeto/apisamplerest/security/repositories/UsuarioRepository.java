package br.com.projeto.apisamplerest.security.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.apisamplerest.security.entities.Usuario;

@Transactional(readOnly = true)
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}
