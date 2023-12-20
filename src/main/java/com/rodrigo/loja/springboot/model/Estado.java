package com.rodrigo.loja.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "sigla", length = 2, nullable = true)
	private String sigla;
	
	private Date dateCreation;
	private Date dateUpdate;
	
	public Estado() {
	}
	
	public Estado(Long id, String name, String sigla, Date dateCreation, Date dateUpdate, List<Cidade> cidade) {
		super();
		this.id = id;
		this.name = name;
		this.sigla = sigla;
		this.dateCreation = dateCreation;
		this.dateUpdate = dateUpdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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

	@Override
	public int hashCode() {
		return Objects.hash(dateCreation, dateUpdate, id, name, sigla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return Objects.equals(dateCreation, other.dateCreation) && Objects.equals(dateUpdate, other.dateUpdate)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(sigla, other.sigla);
	}
	
}
