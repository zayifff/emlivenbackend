package com.emliven.emliven.requests;

import lombok.Data;

@Data
public class CommentUpdateRequest {
	String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
