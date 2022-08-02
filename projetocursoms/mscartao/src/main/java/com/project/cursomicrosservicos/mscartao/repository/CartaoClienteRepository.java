package com.project.cursomicrosservicos.mscartao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cursomicrosservicos.mscartao.model.entity.CartaoClienteEntity;

@Repository
public interface CartaoClienteRepository extends JpaRepository<CartaoClienteEntity, Integer>{

	List<CartaoClienteEntity> findByCpf(String cpf);
}
