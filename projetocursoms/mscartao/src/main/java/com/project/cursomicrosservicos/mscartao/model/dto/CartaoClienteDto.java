package com.project.cursomicrosservicos.mscartao.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.project.cursomicrosservicos.mscartao.model.entity.CartaoClienteEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoClienteDto implements Serializable {
	
	private static final long serialVersionUID = 6854005221449081235L;
	
	private String nome;
	private String bandeira;
	private BigDecimal limiteLiberado;
	
	public static CartaoClienteDto fromModel(CartaoClienteEntity model) {
		return new CartaoClienteDto(
				model.getCartao().getNome(),
				model.getCartao().getBandeira().toString(),
				model.getLimite()) ;
	}
}
