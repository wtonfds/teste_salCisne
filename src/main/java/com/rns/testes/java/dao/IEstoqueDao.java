package com.rns.testes.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rns.testes.java.model.Estoque;

public interface IEstoqueDao extends JpaRepository<Estoque, Long>{

}
