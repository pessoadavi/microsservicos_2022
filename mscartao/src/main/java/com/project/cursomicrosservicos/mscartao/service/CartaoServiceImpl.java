package com.project.cursomicrosservicos.mscartao.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.cursomicrosservicos.mscartao.model.entity.CartaoEntity;
import com.project.cursomicrosservicos.mscartao.repository.CartaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartaoServiceImpl implements CartaoService{

	private final CartaoRepository cartaoRepository;

	@Override
	@Transactional
	public CartaoEntity save(CartaoEntity cartao) {
		return cartaoRepository.saveAndFlush(cartao);
	}

	@Override
	public List<CartaoEntity> getCartoesRendaMenorIgual(Long renda) {
		BigDecimal rendaBigDecimal = BigDecimal.valueOf(renda);
		return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
	}
	
}
