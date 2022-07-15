package com.project.cursomicrosservicos.msavaliadorcredito.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.DadosClienteDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.entity.SituacaoClienteEntity;
import com.project.cursomicrosservicos.msavaliadorcredito.openfeign.msclient.ClienteFeign;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoServiceimpl implements AvaliadorCreditoService {
	
	private final ClienteFeign clienteFeign;
	
	@Override
	public SituacaoClienteEntity obterSituacaoCliente(String cpf) {
		
		Optional<DadosClienteDto> info = clienteFeign.buscarCliente(cpf);
		
		return null;
	}
	
	

}
