package com.rodrigo.loja.springboot.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.loja.springboot.controller.EstadoController;
import com.rodrigo.loja.springboot.exceptions.ResourceNotFoundException;
import com.rodrigo.loja.springboot.mapper.DozerMapper;
import com.rodrigo.loja.springboot.model.Estado;
import com.rodrigo.loja.springboot.model.vo.v1.EstadoVO;
import com.rodrigo.loja.springboot.repository.EstadoRepository;

@Service
public class EstadoServices {
	
private Logger logger = Logger.getLogger(EstadoServices.class.getName());
	
	@Autowired
	private EstadoRepository repository;
	
	public List<EstadoVO> findAll() {
		logger.info("Finding all people");
		var estados =  DozerMapper.parseListObject(repository.findAll(), EstadoVO.class);
		estados.stream().forEach(c-> c.add(linkTo(methodOn(EstadoController.class).findById(c.getKey())).withSelfRel()));
		return estados;
	}
	
	public EstadoVO findById(Long id) {
		logger.info("Finding one estado!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		var vo = DozerMapper.parseObject(entity, EstadoVO.class);
		vo.add(linkTo(methodOn(EstadoController.class).findAll()).withSelfRel());
		return vo;
	}
	
	public EstadoVO create(EstadoVO estado) {
		logger.info("Creating one estado!");
		estado.setDateCreation(new Date());
		var entity = DozerMapper.parseObject(estado, Estado.class);
		var vo = DozerMapper.parseObject(repository.save(entity), EstadoVO.class);
		vo.add(linkTo(methodOn(EstadoController.class).findById(estado.getKey())).withSelfRel());
		return vo;
	}
	
	public EstadoVO update(EstadoVO estado) {
		logger.info("Alterando uma estado");
		var entity = repository.findById(estado.getKey()).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		entity.setName(estado.getName());
		entity.setSigla(estado.getSigla());
		entity.setDateCreation(estado.getDateCreation());
		entity.setDateUpdate(new Date());
		var vo = DozerMapper.parseObject(repository.saveAndFlush(entity), EstadoVO.class);
		vo.add(linkTo(methodOn(EstadoController.class).findById(estado.getKey())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deletando um estado");
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		repository.delete(entity);
	}
}
