package com.totalizator.dao.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by home
 */
@MappedSuperclass
public abstract class GenericEntity implements IGenericEntity, Serializable {
	private static final long serialVersionUID = 6693684972230871997L;
	@Id
	@Column
	@GeneratedValue
	protected Long id;

	public GenericEntity(){

	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
