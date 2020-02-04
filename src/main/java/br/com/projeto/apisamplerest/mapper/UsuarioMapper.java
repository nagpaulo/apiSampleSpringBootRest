package br.com.projeto.apisamplerest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import br.com.projeto.apisamplerest.security.entities.Usuario;

@Mapper
public interface UsuarioMapper {
	@Select("SELECT tu.ci_usuario as id, tu.cd_vinculo_padrao as vinculoPadrao, tu.nm_usuario as usuario, tu.nm_login as login, tu.nm_senha as senha, "
			+ " tu.ds_email as email, tu.nm_cpf as cpf, tu.dt_nascimento as dataNascimento, tu.fl_sexo as sexo, tu.cd_unidade_trabalho as idUnidadeTrabalho, "
			+ " tu.fl_atualizousenha as atualizouSenha, tu.dt_criacao as dataCriacao, tu.fl_usu_prof as usuProf, tu.cd_prefeitura as idPrefeitura, "
			+ " tu.fl_senha_corrigida as senhaCorrigida, tu.fl_ativo as ativo, tu.nm_apelido as apelido, tu.nr_telefone as telefone, "
			+ " tus.* as usuarioId, 'ROLE_ADMIN' as perfil"  
			+ "	FROM util.tb_usuario tu "
			+ " JOIN util.tb_usuario tus ON tus.ci_usuario = tu.cd_usuario "
			+ " WHERE tu.ds_email = '${login}'")
	Usuario findByLogin(@Param("login") String login);
}
