package com.project.cursomicrosservicos.msavaliadorcredito.openfeign.mscartao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.CartaoClienteDto;
import com.project.cursomicrosservicos.msavaliadorcredito.model.dto.CartaoDto;

@FeignClient(name = "mscartao", path="/cartao")
public interface CartaoFeign {
	
	@GetMapping("buscarporrenda/{renda}")
	public List<CartaoDto> getCartoesRendaAte(@PathVariable("renda") Long renda);
	
	@GetMapping("buscarporcpf/{cpf}")
	public List<CartaoClienteDto> getCartoesByCliente(@PathVariable("cpf") String cpf);

}
