package com.project.cursomicrosservicos.msavaliadorcredito.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DadosClienteDto implements Serializable {
	
	private static final long serialVersionUID = -6534199126191573795L;

	private Integer id;
	private String nome;
}
