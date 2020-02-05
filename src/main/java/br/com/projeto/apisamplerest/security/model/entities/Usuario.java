package br.com.projeto.apisamplerest.security.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_usuario", schema = "util")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 306411570471828345L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ci_usuario", nullable = false)
	private Long id;
	
	@Column(name = "cd_vinculo_padrao")
    private String vinculoPadrao;
	
	@Column(name = "nm_usuario")
    private String usuario;
	
	@Column(name = "nm_login")
    private String login;
	
	@Column(name = "nm_senha")
    private String senha;
	
	@Column(name = "ds_email")
    private String email;
	
	@Column(name = "nm_cpf")
    private String cpf;
       
	@Column(name = "dt_nascimento")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataNascimento;
	
	@Column(name = "fl_sexo")
    private Character sexo;
	
	@Column(name = "cd_unidade_trabalho")
    private Long idUnidadeTrabalho;
	
	@Column(name = "fl_atualizousenha")
    private Character atualizouSenha;
    
	@Column(name = "dt_criacao")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataCriacao;  
    
	@Column(name = "fl_usu_prof")
	private String usuProf;
    
	@Column(name = "cd_prefeitura")
	private Integer idPrefeitura;
	
	@Column(name = "fl_senha_corrigida")
    private Character senhaCorrigida;
    
	@Column(name = "fl_ativo")
	private Boolean ativo;
	
	@Column(name = "nm_apelido")
    private String apelido;
	
	@Column(name = "nr_telefone")
    private String telefone;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_usuario")
	private Usuario usuarioId;
	
	@Transient
	private Perfil perfil;
	
}
