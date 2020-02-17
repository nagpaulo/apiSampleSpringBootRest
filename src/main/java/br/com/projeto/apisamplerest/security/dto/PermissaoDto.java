package br.com.projeto.apisamplerest.security.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermissaoDto implements Serializable{
	
	private static final long serialVersionUID = 7721065513993770371L;

	
	@NotNull(message = "ID não pode ser vázio!")
	private Long id;
	
	@NotNull(message = "permissao não pode vázio.")
	@Length(min = 3, max = 300, message = "Nome deve conter entre 3 e 200 caracteres.")
	private String permissao;
	
}
