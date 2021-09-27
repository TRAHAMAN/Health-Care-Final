package com.Sprint.HealthCareSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.User;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Exceptions.UserCreationError;
import com.Sprint.HealthCareSystem.Repository.IAdminRepository;
import com.Sprint.HealthCareSystem.Validators.InputValidator;

@Service
public class IAdminService implements AdminService{

	@Autowired
	IAdminRepository adminRepo;
	
	@Autowired
	InputValidator validate;

	@Override
	public void registerAdmin(String username, String password) throws UserCreationError {
		if(!validate.usernameValidator(username))
			throw new UserCreationError("Check Username !!!!");
		if(!validate.passwordValidator(password))
			throw new UserCreationError("Cannot register this admin with this password");
		if(adminRepo.existsByusername(username)) 
			throw new UserCreationError("username Already exists");
		User u  = new User(username,password,"ADMIN");
		adminRepo.saveAndFlush(u);
	}


	@Override
	public User updateAdmin(User user) throws UserCreationError, DataNotFound {
		if(!validate.usernameValidator(user.getUsername()))
			throw new UserCreationError("Check Username !!!!");
		if(!validate.passwordValidator(user.getPassword()))
			throw new UserCreationError("Cannot register this admin with this password");
		if(!adminRepo.existsById(user.getUid())) 
			throw new DataNotFound("No Such User Exists with id : "+user.getUid());
		adminRepo.saveAndFlush(user);
		return adminRepo.findById(user.getUid()).get();
	}


	@Override
	public User deleteAdmin(int id) throws DataNotFound{
		if(!adminRepo.existsById(id)) throw new DataNotFound("No Such User Exists with id : "+id);
		User user1 = adminRepo.findById(id).get();
		adminRepo.delete(user1);
		return user1;
	}
}
