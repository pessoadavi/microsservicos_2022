package com.project.cursomicrosservicos.msavaliadorcredito.service;

import com.project.cursomicrosservicos.msavaliadorcredito.model.entity.SituacaoClienteEntity;

public interface AvaliadorCreditoService {

	SituacaoClienteEntity obterSituacaoCliente(String cpf);
}
