package com.project.cursomicrosservicos.msavaliadorcredito.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class DadosSolicitacaoEmissaoCartaoDto implements Serializable {
	
	private static final long serialVersionUID = -5513809945909782612L;

	private Long idCartao;
	private String cpf;
	private String endereco;
	private BigDecimal limiteLiberado;
	
}
