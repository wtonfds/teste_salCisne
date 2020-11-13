package com.rns.testes.java.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rns.testes.java.dto.EstoqueDto;
import com.rns.testes.java.model.Estoque;

@Mapper
public interface EstoqueMapper extends GenericMapper<Estoque, EstoqueDto>{
	
	EstoqueMapper INSTANCE = Mappers.getMapper(EstoqueMapper.class);
	
}
