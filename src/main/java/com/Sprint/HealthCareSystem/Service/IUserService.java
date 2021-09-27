package com.Sprint.HealthCareSystem.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.User;
import com.Sprint.HealthCareSystem.Exceptions.UserCreationError;
import com.Sprint.HealthCareSystem.Exceptions.UserNotFound;
import com.Sprint.HealthCareSystem.Repository.IUserRepository;
import com.Sprint.HealthCareSystem.Repository.Queries.QueryClass;
import com.Sprint.HealthCareSystem.Validators.InputValidator;

@Service
public class IUserService implements UserService{
	
	@Autowired
	private IUserRepository iuserRepository;
	@Autowired
	InputValidator validate;
	@Autowired(required = false)
	QueryClass qc;

	@Override
	public User validateUser(String username, String password) throws UserNotFound {
		User pUser = qc.findByUserName(username);
		if(pUser == null )throw new UserNotFound("Invalid Username");
		if(pUser.getPassword().equals(password)) return pUser;
		else {
			throw new UserNotFound("Invalid Password");
		}
	}

	@Override
	public User addUser(User user) throws UserCreationError {
		if(!validate.usernameValidator(user.getUsername()))
			throw new UserCreationError("Check Username !!!!");
		if(iuserRepository.existsByusername(user.getUsername())) 
			throw new UserCreationError("username Already exists");
		if(!validate.passwordValidator(user.getPassword()))
			throw new UserCreationError("Cannot register this User with this password");
		user.setRole("user");
		return iuserRepository.saveAndFlush(user);

	}

	@Override
	public User updateUser(User user) throws UserNotFound {
		if(!iuserRepository.existsById(user.getUid()))
			throw new UserNotFound("User with id :" + user.getUid()+" Doesn't Exist");
		User use = iuserRepository.findById(user.getUid()).get();
		iuserRepository.delete(use);
		return use;
	}

	@Override
	public User removeUser(User user) throws UserNotFound {
		if(!iuserRepository.existsById(user.getUid()))
			throw new UserNotFound("User with id :" + user.getUid()+" Doesn't Exist");
		iuserRepository.deleteById(user.getUid());
		return user;
	}
	
	@Override
	public List<User> getAll() {
		return iuserRepository.findAll();
	}

}
