package com.rns.testes.java.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")
@SequenceGenerator(name = "PRODUTO_SEQ", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
@Data
public class Produto extends GenericEntity<Long>{

    @Id
    @GeneratedValue(generator = "PRODUTO_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String nome;

}
