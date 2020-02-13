package br.com.projeto.apisamplerest.security.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apisamplerest.response.Response;
import br.com.projeto.apisamplerest.security.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/authorization")
@Slf4j
public class PerfilAuthorization {
	
	private static final String TOKEN_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer ";
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping(value = "/list")
	public ResponseEntity<Response<String>> getAuthorizationPerfil(HttpServletRequest request){
		log.info("Buscando autorizações por perfil: {}", "Teste");
		
		Optional<String> token = Optional.ofNullable(request.getHeader(TOKEN_HEADER));
		if (token.isPresent() && token.get().startsWith(BEARER_PREFIX)) {
			token = Optional.of(token.get().substring(7));
		}
		
		String perfil = jwtTokenUtil.getPerfilFromToken(token.get());
		
		Response<String> response = new Response<String>();
		response.setData(perfil);
		return ResponseEntity.ok(response);
	}
}
