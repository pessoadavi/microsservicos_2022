package com.project.cursomicrosservicos.msavaliadorcredito.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartaoAprovadoDto {

	private String cartao;
	private String bandeira;
	private BigDecimal limiteLiberado;
}
