package com.project.cursomicrosservicos.msavaliadorcredito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cursomicrosservicos.msavaliadorcredito.handleexceptions.ErroSolicitacaoCartaoException;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.DadosAvaliacaoDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.DadosSolicitacaoEmissaoCartaoDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.ProtocoloSolicitacaoCartao;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.RetornoAvaliacaoClienteDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.entity.SituacaoClienteEntity;
import com.project.cursomicrosservicos.msavaliadorcredito.service.AvaliadorCreditoService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/avaliadorcredito")
public class AvaliadorCreditoController {
	
	private final AvaliadorCreditoService avaliadorCreditoService;
	
	@GetMapping("/{cpf}")
	public SituacaoClienteEntity consultaSituacaoCliente(@PathVariable("cpf") String cpf) {
		return avaliadorCreditoService.obterSituacaoCliente(cpf);
	}
	
	@PostMapping
	public RetornoAvaliacaoClienteDto realizarAvalicao(@RequestBody DadosAvaliacaoDto dados) {
		return avaliadorCreditoService.realizarAvaliacao(dados.getCpf(), dados.getRenda());
	}
	
	@PostMapping("/solicitacoescartao")
	public ProtocoloSolicitacaoCartao solicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartaoDto dados) {
		try {
			return avaliadorCreditoService.solicitarEmissaoCartao(dados);
		} catch (ErroSolicitacaoCartaoException e) {
			throw new ErroSolicitacaoCartaoException(e.getMessage()); 
		}
	}
	
}
