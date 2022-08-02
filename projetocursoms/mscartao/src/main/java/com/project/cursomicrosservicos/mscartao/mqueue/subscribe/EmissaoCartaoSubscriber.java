package com.project.cursomicrosservicos.mscartao.mqueue.subscribe;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.cursomicrosservicos.mscartao.model.dto.CartaoDto;
import com.project.cursomicrosservicos.mscartao.model.dto.DadosSolicitacaoEmissaoCartaoDto;
import com.project.cursomicrosservicos.mscartao.model.entity.CartaoClienteEntity;
import com.project.cursomicrosservicos.mscartao.model.entity.CartaoEntity;
import com.project.cursomicrosservicos.mscartao.repository.CartaoClienteRepository;
import com.project.cursomicrosservicos.mscartao.repository.CartaoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {
	
	private final CartaoRepository cartaoRepository;
	private final CartaoClienteRepository cartaoClienteRepository;

	@RabbitListener(queues = "${mq.queues.emissao-cartoes}")
	public void receberSolicitacaoEmissao(@Payload String payload) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			DadosSolicitacaoEmissaoCartaoDto dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartaoDto.class);
			CartaoEntity cartao = cartaoRepository.findById(dados.getIdCartao()).orElseThrow();
			CartaoClienteEntity cartaoCliente = new CartaoClienteEntity();
			cartaoCliente.setCartao(cartao);
			cartaoCliente.setCpf(dados.getCpf());
			cartaoCliente.setLimite(dados.getLimiteLiberado());
			
			cartaoClienteRepository.saveAndFlush(cartaoCliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
