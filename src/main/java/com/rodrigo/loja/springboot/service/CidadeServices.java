package com.rodrigo.loja.springboot.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.loja.springboot.controller.CidadeController;
import com.rodrigo.loja.springboot.exceptions.ResourceNotFoundException;
import com.rodrigo.loja.springboot.mapper.DozerMapper;
import com.rodrigo.loja.springboot.model.Cidade;
import com.rodrigo.loja.springboot.model.vo.v1.CidadeVO;
import com.rodrigo.loja.springboot.repository.CidadeRepository;

@Service
public class CidadeServices {
	
	private Logger logger = Logger.getLogger(CidadeServices.class.getName());
	
	@Autowired
	private CidadeRepository repository;
	
	public List<CidadeVO> findAll() {
		logger.info("Finding all people");
		var cidades =  DozerMapper.parseListObject(repository.findAll(), CidadeVO.class);
		cidades.stream().forEach(c-> c.add(linkTo(methodOn(CidadeController.class).findById(c.getKey())).withSelfRel()));
		return cidades;
	}
	
	public CidadeVO findById(Long id) {
		logger.info("Finding one cidade!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		var vo = DozerMapper.parseObject(entity, CidadeVO.class);
		vo.add(linkTo(methodOn(CidadeController.class).findAll()).withSelfRel());
		return vo;
	}
	
	public CidadeVO create(CidadeVO cidade) {
		logger.info("Creating one cidade!");
		cidade.setDateCreation(new Date());
		var entity = DozerMapper.parseObject(cidade, Cidade.class);
		var vo = DozerMapper.parseObject(repository.save(entity), CidadeVO.class);
		vo.add(linkTo(methodOn(CidadeController.class).findById(cidade.getKey())).withSelfRel());
		return vo;
	}
	
	public CidadeVO update(CidadeVO cidade) {
		logger.info("Alterando uma cidade");
		var entity = repository.findById(cidade.getKey()).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		entity.setName(cidade.getName());
		entity.setDateCreation(cidade.getDateCreation());
		entity.setDateUpdate(new Date());
		var vo = DozerMapper.parseObject(repository.saveAndFlush(entity), CidadeVO.class);
		vo.add(linkTo(methodOn(CidadeController.class).findById(cidade.getKey())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deletando um cidade");
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		repository.delete(entity);
	}
}
