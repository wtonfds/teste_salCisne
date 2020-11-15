package com.rns.testes.java.dto.mapper;

import com.rns.testes.java.dto.EstoqueDto;
import com.rns.testes.java.model.Estoque;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-14T14:35:09-0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
public class EstoqueMapperImpl implements EstoqueMapper {

    @Override
    public EstoqueDto entityToDto(Estoque entity) {
        if ( entity == null ) {
            return null;
        }

        EstoqueDto estoqueDto = new EstoqueDto();

        estoqueDto.setVersao( entity.getVersao() );
        estoqueDto.setDataUltAlteracao( entity.getDataUltAlteracao() );
        estoqueDto.setId( entity.getId() );
        estoqueDto.setFilial( entity.getFilial() );

        return estoqueDto;
    }

    @Override
    public Estoque dtoToEntity(EstoqueDto dto) {
        if ( dto == null ) {
            return null;
        }

        Estoque estoque = new Estoque();

        estoque.setVersao( dto.getVersao() );
        estoque.setDataUltAlteracao( dto.getDataUltAlteracao() );
        estoque.setId( dto.getId() );
        estoque.setFilial( dto.getFilial() );

        return estoque;
    }
}
