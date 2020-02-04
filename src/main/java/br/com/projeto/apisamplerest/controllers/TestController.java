package br.com.projeto.apisamplerest.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apisamplerest.response.Response;
import br.com.projeto.apisamplerest.security.dto.UsuarioDto;
import br.com.projeto.apisamplerest.security.entities.Usuario;
import br.com.projeto.apisamplerest.security.services.UsuarioService;

@RestController
@RequestMapping("test")
public class TestController {
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public ResponseEntity<Response<UsuarioDto>> listTest(@RequestParam(value = "login", defaultValue = "") String login){
		log.info("Testando Aplicação!");
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		Optional<Usuario> usuario = this.usuarioService.buscarPorEmail(login);
		
		if(!usuario.isPresent()) {
			log.warn("Nenhum usuario encontrado");
			response.getErrors().add("Nenhum usuario encontrado!"+ login);
            return ResponseEntity.badRequest().body(response);
		}
		
		
		response.setData(this.converteUsuarioDto(usuario.get()));
		return ResponseEntity.ok(response);		
	}
	
	 private UsuarioDto converteUsuarioDto(Usuario usuario){
		 UsuarioDto usuarioDto = new UsuarioDto();
		 usuarioDto.setId(Optional.of(usuario.getId()));
		 usuarioDto.setApelido(usuario.getApelido());
		 usuarioDto.setAtivo(usuario.getAtivo());
		 usuarioDto.setAtualizouSenha(usuario.getAtualizouSenha());
		 usuarioDto.setDataCriacao(usuario.getDataCriacao());
		 usuarioDto.setDataNascimento(usuario.getDataNascimento());
		 usuarioDto.setEmail(usuario.getEmail());
		 usuarioDto.setCpf(usuario.getCpf());
		 usuarioDto.setIdPrefeitura(usuario.getIdPrefeitura());
		 usuarioDto.setIdUnidadeTrabalho(usuario.getIdUnidadeTrabalho());
		 usuarioDto.setLogin(usuario.getLogin());
		 usuarioDto.setSenhaCorrigida(usuarioDto.getSenhaCorrigida());
		 usuarioDto.setSexo(usuario.getSexo());
		 usuarioDto.setTelefone(usuario.getTelefone());
		 usuarioDto.setUsuario(usuario.getUsuario());
		 usuarioDto.setUsuProf(usuario.getUsuProf());
		 usuarioDto.setVinculoPadrao(usuario.getVinculoPadrao());
		 usuarioDto.setUsuarioId(usuario.getUsuarioId().getId());
		 
		 return usuarioDto;
	 }
}
