package com.project.cursomicrosservicos.mscartao.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CartaoClienteEntity implements Serializable {
	
	private static final long serialVersionUID = 7602466271530013515L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name = "id_cartao")
	private CartaoEntity cartao;
	
	private BigDecimal limite;
}
