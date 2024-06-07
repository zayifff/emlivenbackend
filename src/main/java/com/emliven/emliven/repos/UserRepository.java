package com.emliven.emliven.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emliven.emliven.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
