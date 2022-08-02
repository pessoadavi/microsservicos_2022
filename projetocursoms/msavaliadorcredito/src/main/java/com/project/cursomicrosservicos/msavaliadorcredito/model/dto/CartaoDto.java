package com.project.cursomicrosservicos.msavaliadorcredito.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartaoDto implements Serializable {
	
	private static final long serialVersionUID = 5096668927697295298L;

private Integer id;
	
	private String nome;	
	private String bandeira;
	private BigDecimal limite;
 
}
