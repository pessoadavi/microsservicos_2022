package com.project.cursomicrosservicos.mscartao.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.project.cursomicrosservicos.mscartao.enums.BandeiraCartaoEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CartaoEntity implements Serializable {
	
	private static final long serialVersionUID = -7826627737391143859L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private BandeiraCartaoEnum bandeira;
	
	private BigDecimal renda;
	
	private BigDecimal limite;

	public CartaoEntity(String nome, BandeiraCartaoEnum bandeira, BigDecimal renda, BigDecimal limite) {
		super();
		this.nome = nome;
		this.bandeira = bandeira;
		this.renda = renda;
		this.limite = limite;
	}
	
	
	
	

}
