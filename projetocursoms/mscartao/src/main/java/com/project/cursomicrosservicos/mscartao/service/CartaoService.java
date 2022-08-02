package com.project.cursomicrosservicos.mscartao.service;

import java.util.List;

import com.project.cursomicrosservicos.mscartao.model.entity.CartaoEntity;

public interface CartaoService {
	
	public CartaoEntity save(CartaoEntity cartao);
	
	public List<CartaoEntity> getCartoesRendaMenorIgual(Long renda);

}
