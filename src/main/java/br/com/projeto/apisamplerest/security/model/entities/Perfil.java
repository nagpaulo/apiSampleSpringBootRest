package br.com.projeto.apisamplerest.security.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_perfil", schema = "util")
public class Perfil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -113781285116710877L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_perfil")
	private Long id;
	
	@Column(name = "nm_perfil")
	private String perfil;
	
	@Column(name = "dt_criacao")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate criacao;
	
	@Column(name = "ds_role")
	private String role;
	
	@OneToOne
	@JoinColumn(name = "cd_usuario")
	private Usuario usuario;

}
