package br.com.projeto.apisamplerest.security.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService usuarioService;
	
	//@Test
	public void deveValidarEmail() {
		
	}

}
