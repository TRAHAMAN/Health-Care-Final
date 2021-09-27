package com.Sprint.HealthCareSystem.Service;

import org.springframework.stereotype.Service;

import com.Sprint.HealthCareSystem.Entity.User;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Exceptions.UserCreationError;

@Service
public interface AdminService {
	
	public void registerAdmin(String username, String password) throws UserCreationError;

	User updateAdmin(User user) throws UserCreationError, DataNotFound;

	User deleteAdmin(int id) throws DataNotFound;
	
}
