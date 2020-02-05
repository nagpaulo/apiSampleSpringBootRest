package br.com.projeto.apisamplerest.security.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_perfil_usuario", schema = "util")
public class PerfilUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_perfil_usuario")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cd_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "cd_perfil")
	private Perfil perfil;
}
