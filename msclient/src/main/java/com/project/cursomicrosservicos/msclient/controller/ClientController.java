package com.project.cursomicrosservicos.msclient.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cursomicrosservicos.msclient.model.dto.ClientDto;
import com.project.cursomicrosservicos.msclient.model.entity.ClientEntity;
import com.project.cursomicrosservicos.msclient.service.ClientService;

@Controller
@RestController
@RequestMapping("/clientes")
public class ClientController {

	private @Autowired ClientService clientService;
	
	@GetMapping("/{cpf}")
	public Optional<ClientEntity> buscarCliente(@PathVariable("cpf") String cpf) {
		return clientService.getByCpf(cpf);
	}
	
	@PostMapping("/salvar")
	public ClientEntity salvar(@RequestBody ClientDto cliente) {
		BeanUtils.copyProperties(cliente, cliente);
		ClientEntity client = cliente.tomodel();
		return clientService.save(client);
	}
}
