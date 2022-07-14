package com.project.cursomicrosservicos.mscartao.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.project.cursomicrosservicos.mscartao.enums.BandeiraCartaoEnum;
import com.project.cursomicrosservicos.mscartao.model.entity.CartaoEntity;

import lombok.Data;

@Data
public class CartaoDto implements Serializable {
	
	private static final long serialVersionUID = 2121162082537129493L;
	
	private String nome;
	private BandeiraCartaoEnum bandeira;	
	private BigDecimal renda;
	private BigDecimal limite;
		
	public CartaoEntity toModel() {
		return new CartaoEntity(nome, bandeira, renda, limite);
	}
	
	
}
