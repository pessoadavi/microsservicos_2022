package com.project.cursomicrosservicos.msclient.service;

import java.util.List;
import java.util.Optional;

import com.project.cursomicrosservicos.msclient.model.entity.ClientEntity;

public interface ClientService {
	
	Optional<ClientEntity> getByCpf(String cpf);
	
	ClientEntity save(ClientEntity cliente);
	
	List<ClientEntity> getAll();

}
