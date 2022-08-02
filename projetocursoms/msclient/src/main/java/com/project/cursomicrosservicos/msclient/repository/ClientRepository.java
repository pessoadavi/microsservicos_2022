package com.project.cursomicrosservicos.msclient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cursomicrosservicos.msclient.model.entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{

	Optional<ClientEntity> findByCpf(String cpf);

}
