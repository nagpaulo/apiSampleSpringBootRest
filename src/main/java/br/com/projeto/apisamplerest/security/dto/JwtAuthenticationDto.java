package br.com.projeto.apisamplerest.security.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtAuthenticationDto {
	
	@NotEmpty(message = "Usuario não pode ser vazio.")
	private String username;
	
	@NotEmpty(message = "Senha não pode ser vazia.")
	private String senha;

}
