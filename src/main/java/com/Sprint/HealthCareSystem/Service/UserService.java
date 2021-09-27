package com.Sprint.HealthCareSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.User;
import com.Sprint.HealthCareSystem.Exceptions.UserCreationError;
import com.Sprint.HealthCareSystem.Exceptions.UserNotFound;

@Service
public interface UserService {
	
	public User validateUser(String username, String password) throws UserNotFound;
	public User addUser(User user) throws UserCreationError;
	public User removeUser(User user) throws UserNotFound;
	public List<User> getAll();
	public User updateUser(User user) throws UserNotFound;

}
