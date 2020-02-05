package br.com.projeto.apisamplerest.security.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.apisamplerest.security.model.entities.Usuario;

@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
	
	@Query("SELECT u,p FROM Usuario u "
			+ " JOIN PerfilUsuario pu "
			+ " JOIN Perfil p "
			+ " WHERE (u.login = :username OR u.email = :username) ")
	Usuario findByEmailOrLogin(@Param("username") String username);
}
