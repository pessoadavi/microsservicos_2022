package com.project.cursomicrosservicos.msavaliadorcredito.openfeign.msclient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.DadosClienteDto;


@FeignClient(name = "msclient" , path = "/clientes")
public interface ClienteFeign {
	
	@GetMapping("/{cpf}")
	public Optional<DadosClienteDto> buscarCliente(@PathVariable("cpf") String cpf);

}
