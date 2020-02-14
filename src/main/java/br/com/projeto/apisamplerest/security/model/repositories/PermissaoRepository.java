package br.com.projeto.apisamplerest.security.model.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.apisamplerest.security.model.entities.Permissao;

@Transactional
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
	@Query("SELECT tper FROM PerfilPermissao tpp " + 
			" JOIN tpp.permissao tper " + 
			" JOIN tpp.perfil tp " + 
			" WHERE tp.role = :role ")
	Optional<List<Permissao>> buscarPermissaoPorPerfil(@Param("role") String role);
}
