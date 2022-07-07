package com.project.cursomicrosservicos.msclient.service;

import java.util.Optional;

import com.project.cursomicrosservicos.msclient.model.entity.ClientEntity;

public interface ClientService {
	
	public Optional<ClientEntity> getByCpf(String cpf);
	
	public ClientEntity save(ClientEntity cliente);

}
