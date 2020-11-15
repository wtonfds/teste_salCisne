package com.rns.testes.java.model;


import lombok.Data;

import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

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

	@JoinColumn(name = "id_produto")
	@ManyToOne
	private Produto produto;
	
	@JoinColumn(name="id_filial")
	@OneToOne
    private Filial filial;
	
	@Column
	private int quantidade;

}
