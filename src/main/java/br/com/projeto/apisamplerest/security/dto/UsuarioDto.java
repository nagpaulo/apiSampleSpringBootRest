package br.com.projeto.apisamplerest.security.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Convert;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

public class UsuarioDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3960806944951000769L;
	
	private Optional<Long> id = Optional.empty();
    private String data;
    private String vinculoPadrao;
    
    @NotEmpty(message = "O nome do usuario não pode ser vazio.")
    @Length(min = 3, max = 300, message = "Nome deve conter entre 3 e 200 caracteres.")
    private String usuario;
    
    @NotEmpty(message = "O login do usuario não pode ser vazio.")
    @Length(min = 3, max = 300, message = "Nome deve conter entre 3 e 200 caracteres.")
    private String login;
    
    @NotEmpty(message = "O nome do senha não pode ser vazio.")
    @Length(min = 3, max = 300, message = "Nome deve conter entre 3 e 200 caracteres.")
    private String senha;
    
    @NotEmpty(message = "O nome do email não pode ser vazio.")
    @Length(min = 3, max = 300, message = "Nome deve conter entre 3 e 200 caracteres.")
    private String email;
    private String cpf;
        
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataNascimento;
    private Character sexo;
    private Long idUnidadeTrabalho;
    private Character atualizouSenha;
    
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataCriacao;  
    private String usuProf;
    private Integer idPrefeitura;
    private Character senhaCorrigida;
    private Boolean ativo;
    private String apelido;
    private String telefone;
    private Long usuarioId;
    
	public Optional<Long> getId() {
		return id;
	}
	public void setId(Optional<Long> id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
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
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
}

