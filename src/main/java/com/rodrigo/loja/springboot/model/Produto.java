package com.rodrigo.loja.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descriptionShort", length = 50, nullable = false)
	private String descriptionShort;
	
	private String descriptionLong;
	
	@Column(name = "valueCost", nullable = false)
	private Double valueCost;
	
	private Double salesValue;
	private Date dateCreation;
	private Date dateUpdate;
	
	@ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
	
	@ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
	
	public Produto() {
	}

	public Produto(Long id, String descriptionShort, String descriptionLong, Double valueCost, Double salesValue,
			Date dateCreation, Date dateUpdate, Categoria categoria, Marca marca) {
		super();
		this.id = id;
		this.descriptionShort = descriptionShort;
		this.descriptionLong = descriptionLong;
		this.valueCost = valueCost;
		this.salesValue = salesValue;
		this.dateCreation = dateCreation;
		this.dateUpdate = dateUpdate;
		this.categoria = categoria;
		this.marca = marca;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, dateCreation, dateUpdate, descriptionLong, descriptionShort, id, marca,
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
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(dateCreation, other.dateCreation)
				&& Objects.equals(dateUpdate, other.dateUpdate)
				&& Objects.equals(descriptionLong, other.descriptionLong)
				&& Objects.equals(descriptionShort, other.descriptionShort) && Objects.equals(id, other.id)
				&& Objects.equals(marca, other.marca) && Objects.equals(salesValue, other.salesValue)
				&& Objects.equals(valueCost, other.valueCost);
	}

		

}
