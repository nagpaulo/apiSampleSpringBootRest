package br.com.projeto.apisamplerest.security.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import br.com.projeto.apisamplerest.security.enums.PerfilEnum;

@Entity
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
	
	@Enumerated(EnumType.STRING)
	@Transient
	private PerfilEnum perfil;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_usuario")
	private Usuario usuarioId;

	public Usuario() {
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getVinculoPadrao() {
		return vinculoPadrao;
	}


	public void setVinculoPadrao(String vinculoPadrao) {
		this.vinculoPadrao = vinculoPadrao;
	}

	
	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Character getSexo() {
		return sexo;
	}


	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}


	public Long getIdUnidadeTrabalho() {
		return idUnidadeTrabalho;
	}


	public void setIdUnidadeTrabalho(Long idUnidadeTrabalho) {
		this.idUnidadeTrabalho = idUnidadeTrabalho;
	}


	public Character getAtualizouSenha() {
		return atualizouSenha;
	}


	public void setAtualizouSenha(Character atualizouSenha) {
		this.atualizouSenha = atualizouSenha;
	}


	public LocalDate getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public String getUsuProf() {
		return usuProf;
	}


	public void setUsuProf(String usuProf) {
		this.usuProf = usuProf;
	}


	public Integer getIdPrefeitura() {
		return idPrefeitura;
	}


	public void setIdPrefeitura(Integer idPrefeitura) {
		this.idPrefeitura = idPrefeitura;
	}


	public Character getSenhaCorrigida() {
		return senhaCorrigida;
	}


	public void setSenhaCorrigida(Character senhaCorrigida) {
		this.senhaCorrigida = senhaCorrigida;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}


	public String getApelido() {
		return apelido;
	}


	public void setApelido(String apelido) {
		this.apelido = apelido;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((atualizouSenha == null) ? 0 : atualizouSenha.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idPrefeitura == null) ? 0 : idPrefeitura.hashCode());
		result = prime * result + ((idUnidadeTrabalho == null) ? 0 : idUnidadeTrabalho.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((senhaCorrigida == null) ? 0 : senhaCorrigida.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((usuProf == null) ? 0 : usuProf.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((usuarioId == null) ? 0 : usuarioId.hashCode());
		result = prime * result + ((vinculoPadrao == null) ? 0 : vinculoPadrao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (atualizouSenha == null) {
			if (other.atualizouSenha != null)
				return false;
		} else if (!atualizouSenha.equals(other.atualizouSenha))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idPrefeitura == null) {
			if (other.idPrefeitura != null)
				return false;
		} else if (!idPrefeitura.equals(other.idPrefeitura))
			return false;
		if (idUnidadeTrabalho == null) {
			if (other.idUnidadeTrabalho != null)
				return false;
		} else if (!idUnidadeTrabalho.equals(other.idUnidadeTrabalho))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (perfil != other.perfil)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (senhaCorrigida == null) {
			if (other.senhaCorrigida != null)
				return false;
		} else if (!senhaCorrigida.equals(other.senhaCorrigida))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (usuProf == null) {
			if (other.usuProf != null)
				return false;
		} else if (!usuProf.equals(other.usuProf))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (usuarioId == null) {
			if (other.usuarioId != null)
				return false;
		} else if (!usuarioId.equals(other.usuarioId))
			return false;
		if (vinculoPadrao == null) {
			if (other.vinculoPadrao != null)
				return false;
		} else if (!vinculoPadrao.equals(other.vinculoPadrao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", vinculoPadrao=" + vinculoPadrao + ", usuario=" + usuario + ", login=" + login
				+ ", senha=" + senha + ", email=" + email + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ ", sexo=" + sexo + ", idUnidadeTrabalho=" + idUnidadeTrabalho + ", atualizouSenha=" + atualizouSenha
				+ ", dataCriacao=" + dataCriacao + ", usuProf=" + usuProf + ", idPrefeitura=" + idPrefeitura
				+ ", senhaCorrigida=" + senhaCorrigida + ", ativo=" + ativo + ", apelido=" + apelido + ", telefone="
				+ telefone + ", perfil=" + perfil + ", usuarioId=" + usuarioId + "]";
	}

	
}
