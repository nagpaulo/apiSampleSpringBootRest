package br.com.projeto.apisamplerest.security.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_permissao", schema = "util")
public class Permissao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 502193409920878490L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_permissao")
	private Long id;
	
	@Column(name = "nm_permissao")
	private String permissao;

}
