package br.com.projeto.apisamplerest.security.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.projeto.apisamplerest.security.model.entities.PerfilUsuario;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Long>{
	@Query("SELECT pu,u,p FROM PerfilUsuario pu "
			+ " JOIN pu.usuario u "
			+ " JOIN pu.perfil p "
			+ " WHERE (upper(u.login) = upper(:username) OR u.email = :username) ")
	PerfilUsuario findByEmailOrLogin(@Param("username") String username);
}
