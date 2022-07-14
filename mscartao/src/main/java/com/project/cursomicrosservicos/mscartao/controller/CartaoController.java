package com.project.cursomicrosservicos.mscartao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cursomicrosservicos.mscartao.model.dto.CartaoDto;
import com.project.cursomicrosservicos.mscartao.model.entity.CartaoEntity;
import com.project.cursomicrosservicos.mscartao.service.CartaoService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/cartao")
public class CartaoController {
	
	private final CartaoService cartaoService;
		
	@PostMapping("/salvar")
	public CartaoEntity salvar(@RequestBody CartaoDto cartao){
		CartaoEntity cartaoEntity = cartao.toModel(); 
		return cartaoService.save(cartaoEntity);
	}

}
