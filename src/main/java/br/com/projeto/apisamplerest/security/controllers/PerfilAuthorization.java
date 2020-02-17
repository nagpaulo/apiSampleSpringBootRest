package br.com.projeto.apisamplerest.security.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apisamplerest.response.Response;
import br.com.projeto.apisamplerest.security.dto.PermissaoDto;
import br.com.projeto.apisamplerest.security.model.entities.Permissao;
import br.com.projeto.apisamplerest.security.services.PermissaoService;
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
	
	@Autowired
	private PermissaoService permissaoService;
	
	@GetMapping(value = "/list")
	public ResponseEntity<Response<List<PermissaoDto>>> getAuthorizationPerfil(HttpServletRequest request){
		log.info("Buscando autorizações por perfil: {}", "Teste");
		
		Optional<String> token = Optional.ofNullable(request.getHeader(TOKEN_HEADER));
		if (token.isPresent() && token.get().startsWith(BEARER_PREFIX)) {
			token = Optional.of(token.get().substring(7));
		}
		
		String role = jwtTokenUtil.getPerfilFromToken(token.get());
		Optional<List<Permissao>> permissoes = permissaoService.buscarPermissaoPorPerfil(role);
		Response<List<PermissaoDto>> response = new Response<List<PermissaoDto>>();  
		
		if(!permissoes.isPresent()) {
			log.warn("Permissão(ões) não encontrada(s) com a role {}",role);
			response.getErrors().add("Permissão(ões) não encontrada(s) com a role "+role);
			return ResponseEntity.badRequest().body(response);
		}
		
		List<Permissao> listPermissoes = permissoes.get();
		List<PermissaoDto> permissaoDto = listPermissoes
											.stream()
											.map(permissao -> this.convertePermissoaDto(permissao))
											.collect(Collectors.toList());
		
		response.setData(permissaoDto);
		return ResponseEntity.ok(response);
	}
	
	@SuppressWarnings("static-access")
	public PermissaoDto convertePermissoaDto(Permissao permissao) {
		PermissaoDto permissaoDto = new PermissaoDto();
		return permissaoDto.builder()
					.id(permissao.getId())
					.permissao(permissao.getPermissao()).build();
	}
	
}
