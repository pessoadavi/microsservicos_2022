package com.project.cursomicrosservicos.msavaliadorcredito.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RetornoAvaliacaoClienteDto {
	
	List<CartaoAprovadoDto> cartoes;
}
