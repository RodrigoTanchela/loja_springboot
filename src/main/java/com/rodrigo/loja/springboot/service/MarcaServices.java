package com.rodrigo.loja.springboot.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.loja.springboot.exceptions.ResourceNotFoundException;
import com.rodrigo.loja.springboot.mapper.DozerMapper;
import com.rodrigo.loja.springboot.model.Marca;
import com.rodrigo.loja.springboot.model.vo.v1.MarcaVO;
import com.rodrigo.loja.springboot.repository.MarcaRepository;

@Service
public class MarcaServices {
	
private Logger logger = Logger.getLogger(MarcaServices.class.getName());
	
	@Autowired
	private MarcaRepository repository;
	
	public List<MarcaVO> findAll() {
		logger.info("Finding all people");
		var marcas =  DozerMapper.parseListObject(repository.findAll(), MarcaVO.class);
		return marcas;
	}
	
	public MarcaVO findById(Long id) {
		logger.info("Finding one marca!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		var vo = DozerMapper.parseObject(entity, MarcaVO.class);
		return vo;
	}
	
	public MarcaVO create(MarcaVO marca) {
		logger.info("Creating one marca!");
		marca.setDateCreation(new Date());
		var entity = DozerMapper.parseObject(marca, Marca.class);
		var vo = DozerMapper.parseObject(repository.save(entity), MarcaVO.class);
		return vo;
	}
	
	public MarcaVO update(MarcaVO marca) {
		logger.info("Alterando uma marca");
		var entity = repository.findById(marca.getKey()).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		entity.setName(marca.getName());
		entity.setDateCreation(marca.getDateCreation());
		entity.setDateUpdate(new Date());
		var vo = DozerMapper.parseObject(repository.saveAndFlush(entity), MarcaVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deletando um marca");
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		repository.delete(entity);
	}
}
