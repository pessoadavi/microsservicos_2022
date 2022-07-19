package com.project.cursomicrosservicos.mscartao.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class DadosSolicitacaoEmissaoCartaoDto implements Serializable {
	
	private static final long serialVersionUID = -5194574650981369926L;
	
	private Integer idCartao;
	private String cpf;
	private String endereco;
	private BigDecimal limiteLiberado;
	
}