package br.com.projeto.apisamplerest.security.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.projeto.apisamplerest.mapper.UsuarioMapper;
import br.com.projeto.apisamplerest.security.exception.RegraNegocioException;
import br.com.projeto.apisamplerest.security.model.entities.Usuario;
import br.com.projeto.apisamplerest.security.model.repositories.UsuarioRepository;
import br.com.projeto.apisamplerest.security.services.impl.UsuarioServiceImpl;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class UsuarioServiceTest {
	
	UsuarioService service;
	
	@MockBean
	UsuarioRepository repository;
	
	@MockBean
	UsuarioMapper mapper;
	
	@Mock
	Usuario usuario;
	
	String email = "usuario@email.com";
	String login = "login";
	
	@BeforeEach
	public void setUp() {
		this.service = new UsuarioServiceImpl(this.repository, this.mapper);
	}
	
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
		Mockito.when(repository.existsByEmail(email)).thenReturn(true);		
		
		Throwable error = Assertions
			.catchThrowable(() -> service.validarPorEmail(email) );  
		assertThat(error)
			.isInstanceOf(RegraNegocioException.class)
			.hasMessage("Já existe um usuario cadastrado com este email");
	}
	
	
	@Test
	public void deveLancarErroQuandoJaExisteUsuarioCadastradoComOLogin() {
		Mockito.when(usuario.getLogin()).thenReturn(login);
		Mockito.when(repository.existsByLogin(login)).thenReturn(true);

		assertThatThrownBy(() -> service.validarPorLogin(login))
			.isInstanceOf(RegraNegocioException.class)
			.hasMessage("Já existe um usuario cadastrado com este login");
		
	}

}
