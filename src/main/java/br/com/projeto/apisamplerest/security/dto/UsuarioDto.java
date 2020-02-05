package br.com.projeto.apisamplerest.security.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Convert;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
}

