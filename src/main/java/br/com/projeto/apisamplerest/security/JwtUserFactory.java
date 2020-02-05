package br.com.projeto.apisamplerest.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.projeto.apisamplerest.security.model.entities.PerfilUsuario;

public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/**
	 * Converte e gera um JwtUser com base nos dados de um funcionário.
	 * 
	 * @param Usuario
	 * @return JwtUser
	 */
	public static JwtUser create(PerfilUsuario perfilUsuario) {
		return new JwtUser(perfilUsuario.getUsuario().getId(), perfilUsuario.getUsuario().getEmail(), perfilUsuario.getUsuario().getSenha(),
				mapToGrantedAuthorities(perfilUsuario.getPerfil().getRole()));
	}

	/**
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 * 
	 * @param perfilEnum
	 * @return List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(String perfil) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfil));
		return authorities;
	}

}
