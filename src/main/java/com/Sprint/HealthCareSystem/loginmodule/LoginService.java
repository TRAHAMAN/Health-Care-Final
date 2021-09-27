package com.Sprint.HealthCareSystem.loginmodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.User;
import com.Sprint.HealthCareSystem.Exceptions.UserNotFound;
import com.Sprint.HealthCareSystem.Repository.IUserRepository;
import com.Sprint.HealthCareSystem.Repository.Queries.QueryClass;

@Service
public class LoginService {
	@Autowired(required = false)
	private QueryClass qc;
	
	@Autowired
	private IUserRepository uRepo;

	
	public User loginWithData(String username, String password) throws UserNotFound {
		User user;
		user = qc.findByUserName(username);
		if(user.isLoggedIn())
			throw new UserNotFound("User Already Logged In ");
		if(!user.getPassword().equals(password))
			throw new UserNotFound("Invalid Password");
		user.setLoggedIn(true);
		uRepo.saveAndFlush(user);
		return user;
	}
	

	public User logoutPresentUser(String userName) throws UserNotFound {
		User user = qc.findByUserName(userName);
		if(user.isLoggedIn()) {
			user.setLoggedIn(false);
		}
		else {
			throw new UserNotFound("User Not Logged In");
		}
		
		return uRepo.saveAndFlush(user);
	}
	

	
}
