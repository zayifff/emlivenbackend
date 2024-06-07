package com.emliven.emliven.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
	Long id;
	Long userId;
	Long eventsId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getEventsId() {
		return eventsId;
	}
	public void setEventsId(Long eventsId) {
		this.eventsId = eventsId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	String text;
}
