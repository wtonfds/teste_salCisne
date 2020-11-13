package com.rns.testes.java.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ESTOQUE")
@SequenceGenerator(name = "ESTOQUE_SEQ", sequenceName = "ESTOQUE_SEQ", allocationSize = 1)
@Data
public class Estoque extends GenericEntity<Long> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "ESTOQUE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

	@Column
    private Filial filial;
	
	@Column
	private Produto produto;
	
	@Column
	private int quantidade;

}
