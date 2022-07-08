package com.project.cursomicrosservicos.msclient.model.dto;

import java.io.Serializable;

import com.project.cursomicrosservicos.msclient.model.entity.ClientEntity;

import lombok.Data;

@Data
public class ClientDto implements Serializable{
	
	private static final long serialVersionUID = 905515219393369758L;

	private String cpf;
	private String nome;
	private Integer idade;
	
	public ClientEntity tomodel() {
		return new ClientEntity(cpf, nome, idade);
	}
	
	
}
