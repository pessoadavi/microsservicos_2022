package com.project.cursomicrosservicos.msavaliadorcredito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return null;
	}
	

}
