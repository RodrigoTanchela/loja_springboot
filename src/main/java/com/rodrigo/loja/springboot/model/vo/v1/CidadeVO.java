package com.rodrigo.loja.springboot.model.vo.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"id", "name", "dateCreation", "dateUpdate", "estado"})
public class CidadeVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	
	private String name;
	
	private Date dateCreation;
	private Date dateUpdate;
	
	@JsonProperty("estado")
	@Mapping("estado")
    private EstadoVO estado;
	
	public CidadeVO() {
	}

	public CidadeVO(Long key, String name, Date dateCreation, Date dateUpdate, EstadoVO estado) {
		this.key = key;
		this.name = name;
		this.dateCreation = dateCreation;
		this.dateUpdate = dateUpdate;
		this.estado = estado;
	}
	
	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public EstadoVO getEstado() {
		return estado;
	}

	public void setEstado(EstadoVO estado) {
		this.estado = estado;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return Objects.hash(dateCreation, dateUpdate, estado, key, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CidadeVO other = (CidadeVO) obj;
		return Objects.equals(dateCreation, other.dateCreation) && Objects.equals(dateUpdate, other.dateUpdate)
				&& Objects.equals(estado, other.estado) && Objects.equals(key, other.key)
				&& Objects.equals(name, other.name);
	}
	
}
