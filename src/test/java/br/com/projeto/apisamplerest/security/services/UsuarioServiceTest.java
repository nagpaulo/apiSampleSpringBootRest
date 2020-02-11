package br.com.projeto.apisamplerest.security.services;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.projeto.apisamplerest.security.exception.RegraNegocioException;
import br.com.projeto.apisamplerest.security.model.entities.Usuario;
import br.com.projeto.apisamplerest.security.model.repositories.UsuarioRepository;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class UsuarioServiceTest {
	
	@SpyBean
	UsuarioService service;
	
	@MockBean
	UsuarioRepository repository;
	
	@Mock
	Usuario usuario;
	
	String email = "usuario@email.com";
	String login = "login";
	
	@Test
	public void deveValidarEmail() {
		Mockito.when(usuario.getEmail()).thenReturn(email);
		service.validarPorEmail(email);
	}
	
	@Test
	public void deveValidarLogin() {
		Mockito.when(usuario.getLogin()).thenReturn(login);
		service.validarPorLogin(login);
	}
	
	@Test
	public void deveLancarErroQuandoJaExisteUsuarioCadastradoComOEmail() {
		Mockito.when(usuario.getEmail()).thenReturn(email);
		Mockito.when(repository.findByEmail(email)).thenReturn(usuario);
		
		assertThatThrownBy(() -> { service.validarPorEmail(email); }).isInstanceOf(RegraNegocioException.class)
			.hasMessage("Já existe um usuario cadastrado com este email");
	}

}
