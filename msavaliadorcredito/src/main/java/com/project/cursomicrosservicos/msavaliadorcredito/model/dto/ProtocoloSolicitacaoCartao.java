package com.project.cursomicrosservicos.msavaliadorcredito.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProtocoloSolicitacaoCartao implements Serializable {
	
	private static final long serialVersionUID = -5272717657739928119L;

	private String protocolo;
}
