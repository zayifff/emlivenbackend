package com.emliven.emliven.requests;

import lombok.Data;

@Data

public class EventsUpdateRequest {
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	String title;
	String text;
	String type;
	int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
