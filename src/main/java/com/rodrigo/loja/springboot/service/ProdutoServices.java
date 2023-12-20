package com.rodrigo.loja.springboot.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.loja.springboot.exceptions.ResourceNotFoundException;
import com.rodrigo.loja.springboot.mapper.DozerMapper;
import com.rodrigo.loja.springboot.model.Produto;
import com.rodrigo.loja.springboot.model.vo.v1.ProdutoVO;
import com.rodrigo.loja.springboot.repository.ProdutoRepository;

@Service
public class ProdutoServices {
	
	private Logger logger = Logger.getLogger(ProdutoServices.class.getName());
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<ProdutoVO> findAll() {
		logger.info("Finding all people");
		var produtos =  DozerMapper.parseListObject(repository.findAll(), ProdutoVO.class);
		return produtos;
	}
	
	public ProdutoVO findById(Long id) {
		logger.info("Finding one produto!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		var vo = DozerMapper.parseObject(entity, ProdutoVO.class);
		return vo;
	}
	
	public ProdutoVO create(ProdutoVO produto) {
		logger.info("Creating one produto!");
		produto.setDateCreation(new Date());
		var entity = DozerMapper.parseObject(produto, Produto.class);
		var vo = DozerMapper.parseObject(repository.save(entity), ProdutoVO.class);
		return vo;
	}
	
	public ProdutoVO update(ProdutoVO produto) {
		var entity = repository.findById(produto.getKey()).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		entity.setDescriptionShort(produto.getDescriptionShort());
		entity.setDescriptionLong(produto.getDescriptionLong());
		entity.setValueCost(produto.getValueCost());
		entity.setSalesValue(produto.getSalesValue());
		entity.setDateUpdate(new Date());
		var vo = DozerMapper.parseObject(repository.saveAndFlush(entity), ProdutoVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		repository.delete(entity);
	}
}
