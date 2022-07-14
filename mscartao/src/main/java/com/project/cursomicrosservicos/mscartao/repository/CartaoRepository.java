package com.project.cursomicrosservicos.mscartao.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cursomicrosservicos.mscartao.model.entity.CartaoEntity;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, Integer>{
	
	List<CartaoEntity> findByRendaLessThanEqual(BigDecimal renda);

}
