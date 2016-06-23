package com.totalizator.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by home
 */
@Entity
@Table(name = "messages")
public class Message extends GenericEntity {
	@Column
	private String text = "";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
