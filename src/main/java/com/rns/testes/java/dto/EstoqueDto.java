package com.rns.testes.java.dto;

import com.rns.testes.java.model.Filial;
import com.rns.testes.java.model.GenericEntity;
import com.rns.testes.java.model.Produto;

import lombok.Data;

@Data
public class EstoqueDto extends GenericEntity<Long>{

	public Long id;
	private Filial filial;
	private Produto produto;
	private int quatidade;

}
