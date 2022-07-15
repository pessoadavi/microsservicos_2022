package com.project.cursomicrosservicos.msavaliadorcredito.model.entity;

import java.io.Serializable;
import java.util.List;

import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.CartaoClienteDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.DadosClienteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SituacaoClienteEntity implements Serializable {
	
	private static final long serialVersionUID = 7521704623431251771L;

	private DadosClienteDto cliente;
	
	private List<CartaoClienteDto> cartoes;
	
}
