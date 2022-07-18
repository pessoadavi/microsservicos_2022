package com.project.cursomicrosservicos.msavaliadorcredito.service;

import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.RetornoAvaliacaoClienteDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.entity.SituacaoClienteEntity;

public interface AvaliadorCreditoService {

	SituacaoClienteEntity obterSituacaoCliente(String cpf);
	
	RetornoAvaliacaoClienteDto realizarAvaliacao(String cpf, Long renda);
}
