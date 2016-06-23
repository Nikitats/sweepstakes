package com.totalizator.web.viewmodels;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by home
 */
@JsonAutoDetect
public class MessageViewModel {

	private long id;
	private String text = "";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
