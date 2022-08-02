package com.project.cursomicrosservicos.msavaliadorcredito.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DadosAvaliacaoDto implements Serializable {
	
	private static final long serialVersionUID = -3499168801111436122L;
	
	private String cpf;
	private Long renda;
}
