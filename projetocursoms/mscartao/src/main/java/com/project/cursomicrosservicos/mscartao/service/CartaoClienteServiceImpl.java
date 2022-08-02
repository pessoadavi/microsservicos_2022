package com.project.cursomicrosservicos.mscartao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.cursomicrosservicos.mscartao.model.entity.CartaoClienteEntity;
import com.project.cursomicrosservicos.mscartao.repository.CartaoClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartaoClienteServiceImpl implements CartaoClienteService{
	
	private final CartaoClienteRepository cartaoClienteRepository;

	@Override
	public List<CartaoClienteEntity> listCartoesByCpf(String cpf) {
		return cartaoClienteRepository.findByCpf(cpf);
	}
	
	

}
