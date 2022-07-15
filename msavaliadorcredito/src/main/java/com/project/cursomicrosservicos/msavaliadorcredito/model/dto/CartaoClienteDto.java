package com.project.cursomicrosservicos.msavaliadorcredito.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartaoClienteDto implements Serializable {

	private static final long serialVersionUID = 5127631491394888677L;

	private String nome;
	private String bandeira;
	private BigDecimal limiteLiberado;
}
