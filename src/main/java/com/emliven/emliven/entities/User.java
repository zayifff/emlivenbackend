package com.emliven.emliven.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name ="user")
@Data
public class User {
    @Id
    Long id;
    String title;
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	String userName;
    String password;
    
    // Getter and setter methods for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter methods for userName
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter and setter methods for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
