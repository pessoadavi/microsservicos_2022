package com.project.cursomicrosservicos.mscartao.service;

import java.util.List;

import com.project.cursomicrosservicos.mscartao.model.entity.CartaoClienteEntity;

public interface CartaoClienteService {

	List<CartaoClienteEntity> listCartoesByCpf(String cpf);
}
