package com.project.cursomicrosservicos.msavaliadorcredito.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.cursomicrosservicos.msavaliadorcredito.handleexceptions.ErroSolicitacaoCartaoException;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.CartaoAprovadoDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.CartaoClienteDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.CartaoDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.DadosClienteDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.DadosSolicitacaoEmissaoCartaoDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.ProtocoloSolicitacaoCartao;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.RetornoAvaliacaoClienteDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.entity.SituacaoClienteEntity;
import com.project.cursomicrosservicos.msavaliadorcredito.mqueue.publisher.SolicitacaoEmissaoCartaoPublisher;
import com.project.cursomicrosservicos.msavaliadorcredito.openfeign.mscartao.CartaoFeign;
import com.project.cursomicrosservicos.msavaliadorcredito.openfeign.msclient.ClienteFeign;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoServiceimpl implements AvaliadorCreditoService {
	
	private final CartaoFeign cartaoFeign;
	private final ClienteFeign clienteFeign;
	private final SolicitacaoEmissaoCartaoPublisher emissaoCartaoPublisher;
	
	@Override
	public SituacaoClienteEntity obterSituacaoCliente(String cpf) {
		
		Optional<DadosClienteDto> clientInfo = clienteFeign.buscarCliente(cpf);
		List<CartaoClienteDto> cartaoInfo = cartaoFeign.getCartoesByCliente(cpf); 
		
		return new SituacaoClienteEntity(clientInfo, cartaoInfo);
	}

	@Override
	public RetornoAvaliacaoClienteDto realizarAvaliacao(String cpf, Long renda) {
		
		List<CartaoDto> cartoesInfo = cartaoFeign.getCartoesRendaAte(renda);
		Optional<DadosClienteDto> clientInfo = clienteFeign.buscarCliente(cpf);
		
		List<CartaoAprovadoDto> aprovados = cartoesInfo.stream().map(c-> {
			
			BigDecimal limiteBasico = c.getLimite();
			BigDecimal idadeDB = BigDecimal.valueOf(clientInfo.get().getIdade());
			BigDecimal fator = idadeDB.divide(BigDecimal.valueOf(10));
			BigDecimal limiteAprovado = fator.multiply(limiteBasico);
			
			CartaoAprovadoDto cartaoAprovado = new CartaoAprovadoDto(); 
			cartaoAprovado.setCartao(c.getNome());
			cartaoAprovado.setBandeira(c.getBandeira());
			cartaoAprovado.setLimiteLiberado(limiteAprovado);
			return cartaoAprovado;
		}).collect(Collectors.toList());
		
		return new RetornoAvaliacaoClienteDto(aprovados);
	}

	@Override
	public ProtocoloSolicitacaoCartao solicitarEmissaoCartao(DadosSolicitacaoEmissaoCartaoDto dados) {
		
		try {
			emissaoCartaoPublisher.solicitarCartao(dados);
			String protocolo = UUID.randomUUID().toString();
			return new ProtocoloSolicitacaoCartao(protocolo);
		} catch (Exception e) {
			throw new ErroSolicitacaoCartaoException(e.getMessage());
		}
	}
	
}
