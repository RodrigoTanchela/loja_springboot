package com.rodrigo.loja.springboot.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.loja.springboot.exceptions.ResourceNotFoundException;
import com.rodrigo.loja.springboot.mapper.DozerMapper;
import com.rodrigo.loja.springboot.model.Categoria;
import com.rodrigo.loja.springboot.model.vo.v1.CategoriaVO;
import com.rodrigo.loja.springboot.repository.CategoriaRepository;

@Service
public class CategoriaServices {
	
	private Logger logger = Logger.getLogger(CategoriaServices.class.getName());
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<CategoriaVO> findAll() {
		logger.info("Finding all people");
		var categorias =  DozerMapper.parseListObject(repository.findAll(), CategoriaVO.class);
		return categorias;
	}
	
	public CategoriaVO findById(Long id) {
		logger.info("Finding one categoria!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		var vo = DozerMapper.parseObject(entity, CategoriaVO.class);
		return vo;
	}
	
	public CategoriaVO create(CategoriaVO categoria) {
		logger.info("Creating one categoria!");
		categoria.setDateCreation(new Date());
		var entity = DozerMapper.parseObject(categoria, Categoria.class);
		var vo = DozerMapper.parseObject(repository.save(entity), CategoriaVO.class);
		return vo;
	}
	
	public CategoriaVO update(CategoriaVO categoria) {
		logger.info("Alterando uma categoria");
		var entity = repository.findById(categoria.getKey()).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		entity.setName(categoria.getName());
		entity.setDateCreation(categoria.getDateCreation());
		entity.setDateUpdate(new Date());
		var vo = DozerMapper.parseObject(repository.saveAndFlush(entity), CategoriaVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deletando um categoria");
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		repository.delete(entity);
	}
}
