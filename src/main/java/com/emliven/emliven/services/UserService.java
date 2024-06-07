package com.emliven.emliven.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emliven.emliven.entities.User;
import com.emliven.emliven.repos.UserRepository;

@Service
public class UserService {
	
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}

	public User getOneUser(Long userID) {
		return userRepository.findById(userID).orElse(null);
	}

	public User updateOneUser(Long userID, User newUser) {
		Optional<User> user = userRepository.findById(userID);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			foundUser.setTitle(newUser.getTitle());
			userRepository.save(foundUser);
			return foundUser;
		}else
			return null;
	}

	public void deleteById(Long userID) {
		userRepository.deleteById(userID);
		
	}


    
}
