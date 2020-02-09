package br.com.projeto.apisamplerest.security.model.repositories;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.projeto.apisamplerest.security.model.entities.Usuario;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	public void deveVerificarAexistenciaDeUmEmail() {
		//Cenario
		Usuario usuario = Usuario.builder()
									.login("nagpaulo")
									.email("nagpaulo@gmail.com")
									.senha("123").build();
		this.usuarioRepository.save(usuario);
		
		//Ação/Execução
		boolean result = this.usuarioRepository.existsByEmail("nagpaulo@gmail.com");
		
		//Verificação
		Assertions.assertThat(result).isTrue();
		
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {
		//Cenario
		this.usuarioRepository.deleteAll();
		
		//Ação/Execução
		boolean result = this.usuarioRepository.existsByEmail("nagpaulo@gmail.com");
		
		//Verificação
		Assertions.assertThat(result).isFalse();
		
	}
	
	@Test
	public void deveVerificarAexistenciaDeUmLogin() {
		//Cenario
		Usuario usuario = Usuario.builder()
									.login("nagpaulo")
									.email("nagpaulo@gmail.com")
									.senha("123").build();
		this.usuarioRepository.save(usuario);
		
		//Ação/Execução
		boolean result = this.usuarioRepository.existsByLogin("nagpaulo");
		
		//Verificação
		Assertions.assertThat(result).isTrue();
		
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOLogin() {
		//Cenario
		this.usuarioRepository.deleteAll();
		
		//Ação/Execução
		boolean result = this.usuarioRepository.existsByLogin("nagpaulo");
		
		//Verificação
		Assertions.assertThat(result).isFalse();
		
	}
	
	@Test
	public void deveRetornaUmUsuarioCadastradoOuComLoginOuEmail() {
		this.usuarioRepository.deleteAll();
		Usuario usuario = Usuario.builder()
				.login("nagpaulo")
				.email("nagpaulo@gmail.com")
				.senha("123").build();
		this.usuarioRepository.save(usuario);
		
		Usuario login = this.usuarioRepository.findByEmailOrLogin("nagpaulo");
		Usuario email = this.usuarioRepository.findByEmailOrLogin("nagpaulo@gmail.com");
		
		Assertions.assertThat(Optional.ofNullable(login).isPresent()).isTrue();
		Assertions.assertThat(Optional.ofNullable(email).isPresent()).isTrue();
	}
	
	
}
