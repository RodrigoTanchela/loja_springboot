package com.rodrigo.loja.springboot.model.vo.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;


public class ProdutoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	
	private String descriptionShort;
	private String descriptionLong;
	private Double valueCost;
	
	private Double salesValue;
	private Date dateCreation;
	private Date dateUpdate;
	
	@JsonProperty("categoria")
	@Mapping("categoria")
    private CategoriaVO categoria;
	
	@JsonProperty("marca")
	@Mapping("marca")
    private MarcaVO marca;
	
	public ProdutoVO() {
	}
	
	public ProdutoVO(Long key, String descriptionShort, String descriptionLong, Double valueCost, Double salesValue,
			Date dateCreation, Date dateUpdate, CategoriaVO categoria, MarcaVO marca) {
		this.key = key;
		this.descriptionShort = descriptionShort;
		this.descriptionLong = descriptionLong;
		this.valueCost = valueCost;
		this.salesValue = salesValue;
		this.dateCreation = dateCreation;
		this.dateUpdate = dateUpdate;
		this.categoria = categoria;
		this.marca = marca;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getDescriptionShort() {
		return descriptionShort;
	}

	public void setDescriptionShort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
	}

	public String getDescriptionLong() {
		return descriptionLong;
	}

	public void setDescriptionLong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}

	public Double getValueCost() {
		return valueCost;
	}

	public void setValueCost(Double valueCost) {
		this.valueCost = valueCost;
	}

	public Double getSalesValue() {
		return salesValue;
	}

	public void setSalesValue(Double salesValue) {
		this.salesValue = salesValue;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public CategoriaVO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaVO categoria) {
		this.categoria = categoria;
	}

	public MarcaVO getMarca() {
		return marca;
	}

	public void setMarca(MarcaVO marca) {
		this.marca = marca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, dateCreation, dateUpdate, descriptionLong, descriptionShort, key, marca,
				salesValue, valueCost);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoVO other = (ProdutoVO) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(dateCreation, other.dateCreation)
				&& Objects.equals(dateUpdate, other.dateUpdate)
				&& Objects.equals(descriptionLong, other.descriptionLong)
				&& Objects.equals(descriptionShort, other.descriptionShort) && Objects.equals(key, other.key)
				&& Objects.equals(marca, other.marca) && Objects.equals(salesValue, other.salesValue)
				&& Objects.equals(valueCost, other.valueCost);
	}
	
}
