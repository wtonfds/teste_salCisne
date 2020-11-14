package com.rns.testes.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.rns.testes.java.dto.EstoqueDto;
import com.rns.testes.java.dto.FilialDto;
import com.rns.testes.java.dto.mapper.EstoqueMapper;
import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.service.IEstoqueService;

@CrossOrigin
@RestController
@RequestMapping
public class EstoqueController {
	
	private static final String BASE_URL = "estoque/";
	
	@Autowired
	IEstoqueService service;
	
	@Autowired
	Filial filial;

	@GetMapping(value = BASE_URL + "find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Estoque>> findAll(){
	return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping(value = BASE_URL + "find-by-id", produces = MediaType.APPLICATION_JSON_VALUE, params = {"id"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Estoque> findById(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
	
	@PostMapping(value = BASE_URL + "insert", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Estoque> insert(@RequestBody EstoqueDto dto){
		return ResponseEntity.ok(service.save(EstoqueMapper.INSTANCE.dtoToEntity(dto)));
	}
	
	@PutMapping(value = BASE_URL + "update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Estoque> update(@RequestBody EstoqueDto dto){
		return ResponseEntity.ok(service.update(EstoqueMapper.INSTANCE.dtoToEntity(dto)));
	}
	
	@DeleteMapping(value = BASE_URL + "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
	public void delete(@RequestParam(name = "id") Long id) {
		service.delete(id);
	}
	
	@DeleteMapping(value = BASE_URL + "trasnfer-product", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Estoque> trasferProduct(@RequestBody Filial newFilial, @RequestBody EstoqueDto estoque){
		
		estoque.setFilial(newFilial);
		
		return ResponseEntity.ok(service.update(EstoqueMapper.INSTANCE.dtoToEntity(estoque)));
		
	}
}
