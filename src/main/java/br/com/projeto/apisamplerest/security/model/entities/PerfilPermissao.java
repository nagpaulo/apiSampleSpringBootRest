package br.com.projeto.apisamplerest.security.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_perfil_permissao", schema = "util")
public class PerfilPermissao implements Serializable{
	
	private static final long serialVersionUID = 6147711346893524895L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_perfil_permissao")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cd_perfil")
	private Perfil perfil;
	@ManyToOne
	@JoinColumn(name = "cd_permissao")
	private Permissao permissao;

}
