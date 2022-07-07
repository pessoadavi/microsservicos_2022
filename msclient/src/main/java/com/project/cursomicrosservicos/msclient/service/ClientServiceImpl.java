package com.project.cursomicrosservicos.msclient.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.cursomicrosservicos.msclient.model.entity.ClientEntity;
import com.project.cursomicrosservicos.msclient.repository.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

	private final @Autowired ClientRepository clientRepository;

	@Override
	public Optional<ClientEntity> getByCpf(String cpf) {
		return clientRepository.findByCpf(cpf);
	}	
	
	@Override
	@Transactional
	public ClientEntity save(ClientEntity cliente) {
		return clientRepository.saveAndFlush(cliente);
	}

}
