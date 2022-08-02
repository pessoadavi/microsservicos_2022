package com.project.cursomicrosservicos.mscartao.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cursomicrosservicos.mscartao.model.dto.CartaoClienteDto;
import com.project.cursomicrosservicos.mscartao.model.dto.CartaoDto;
import com.project.cursomicrosservicos.mscartao.model.entity.CartaoClienteEntity;
import com.project.cursomicrosservicos.mscartao.model.entity.CartaoEntity;
import com.project.cursomicrosservicos.mscartao.service.CartaoClienteService;
import com.project.cursomicrosservicos.mscartao.service.CartaoService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/cartao")
public class CartaoController {
	
	private final CartaoService cartaoService;
	private final CartaoClienteService cartaoClienteService;
		
	@GetMapping("buscarporrenda/{renda}")
	public List<CartaoEntity> getCartoesRendaAte(@PathVariable("renda") Long renda){
		return cartaoService.getCartoesRendaMenorIgual(renda);
	}
	
	@GetMapping("buscarporcpf/{cpf}")
	public List<CartaoClienteDto> getCartoesByCliente(@PathVariable("cpf") String cpf){
		List<CartaoClienteEntity> list = cartaoClienteService.listCartoesByCpf(cpf);
		List<CartaoClienteDto> resultList = list.stream().map(CartaoClienteDto::fromModel).collect(Collectors.toList());
		return resultList;	
	
	}
	
	@PostMapping("/salvar")
	public CartaoEntity salvar(@RequestBody CartaoDto cartao){
		CartaoEntity cartaoEntity = cartao.toModel(); 
		return cartaoService.save(cartaoEntity);
	}

}
