package com.rns.testes.java.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rns.testes.java.enums.EnumTipoFilial;
import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.model.Produto;
import com.rns.testes.java.service.IEstoqueService;
import com.rns.testes.java.service.IFilialService;
import com.rns.testes.java.service.IProdutoService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EstoqueSeeder {
	
	@Autowired
	IEstoqueService eService;
	
	@Autowired
	IFilialService fService;
	
	@Autowired
	IProdutoService pService;
	
	
	@EventListener
    public void seedFilial(ContextRefreshedEvent event) {
        try {
            log.info("Criando Estoque....");
            criandoEstoque();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
	
	private void criandoEstoque() {
		
		/* criacao de filial */
		
        Filial galpao = new Filial();
        galpao.setRazaoSocial("Galpao de estocagem de produtos LTDA");
        galpao.setCnpj("83.230.227/0001-50");
        galpao.setTipoFilial(EnumTipoFilial.DEPOSITO);
        galpao.setEndereco("Rua Teste Galpao 187, São Paulo - SP");

        fService.save(galpao);

        Filial lojaBtoC1 = new Filial();
        lojaBtoC1.setRazaoSocial("Loja São Paulo LTDA");
        lojaBtoC1.setCnpj("72.286.494/0001-23");
        lojaBtoC1.setTipoFilial(EnumTipoFilial.LOJA_PF);
        lojaBtoC1.setEndereco("Av. Paulista, 111, São Paulo - SP");

        fService.save(lojaBtoC1);

        Filial lojaBtoC2 = new Filial();
        lojaBtoC2.setRazaoSocial("Loja Rio de Janeiro LTDA");
        lojaBtoC2.setCnpj("50.935.855/0001-82");
        lojaBtoC2.setTipoFilial(EnumTipoFilial.LOJA_PF);
        lojaBtoC2.setEndereco("Av. Barata Ribeiro, 199, Rio de Janeiro - RJ");

        fService.save(lojaBtoC2);

        Filial lojaBtoB = new Filial();
        lojaBtoB.setRazaoSocial("Loja To Loja LTDA");
        lojaBtoB.setCnpj("82.602.541/0001-54");
        lojaBtoB.setTipoFilial(EnumTipoFilial.LOJA_PJ);
        lojaBtoB.setEndereco("Av. Barata Ribeiro, 124, Rio de Janeiro - RJ");

        fService.save(lojaBtoB);
        
        
        /* criacao de produto */
        
        Produto produto1 = new Produto();
        produto1.setNome("Sal Cisne 1");
        
        pService.save(produto1);
        
        Produto produto2 = new Produto();
        produto2.setNome("Sal Cisne 2");
        
        pService.save(produto2);
        
        Produto produto3 = new Produto();
        produto3.setNome("Sal Cisne 3");
        
        pService.save(produto3);
        
        /* Criacao de estoque */
        
        Estoque etqlojaBtoC2 = new Estoque();
        etqlojaBtoC2.setFilial(lojaBtoC2);
        etqlojaBtoC2.setProduto(produto3);
        etqlojaBtoC2.setQuantidade(2100);
		
		eService.save(etqlojaBtoC2);
		
		Estoque etqlojaBtoB = new Estoque();
		etqlojaBtoB.setFilial(lojaBtoB);
		etqlojaBtoB.setProduto(produto1);
		etqlojaBtoB.setQuantidade(1600);
		
		eService.save(etqlojaBtoC2);
        
        Estoque etqlojaBtoC1 = new Estoque();
        etqlojaBtoC1.setFilial(lojaBtoB);
        etqlojaBtoC1.setProduto(produto3);
        etqlojaBtoC1.setQuantidade(2000);
		
		eService.save(etqlojaBtoC1);
		
		Estoque etqGalpao = new Estoque();
		etqGalpao.setFilial(galpao);
		etqGalpao.setProduto(produto2);
		etqGalpao.setQuantidade(24);
		
		eService.save(etqGalpao);
		
		
		
    }
	
		
}
