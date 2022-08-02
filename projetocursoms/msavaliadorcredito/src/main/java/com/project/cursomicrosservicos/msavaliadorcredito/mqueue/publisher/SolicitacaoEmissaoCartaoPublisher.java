package com.project.cursomicrosservicos.msavaliadorcredito.mqueue.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.DadosSolicitacaoEmissaoCartaoDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SolicitacaoEmissaoCartaoPublisher {
	
	private final Queue queueEmissaoCartoes;
	private final RabbitTemplate rabbitTemplate;
	
	public void solicitarCartao(DadosSolicitacaoEmissaoCartaoDto dados) throws JsonProcessingException{
		String json = convertIntoJson(dados);
		rabbitTemplate.convertAndSend(queueEmissaoCartoes.getName(), json);
	}
	
	private String convertIntoJson(DadosSolicitacaoEmissaoCartaoDto dados) throws JsonProcessingException{
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(dados);
		return json;
	}
}
