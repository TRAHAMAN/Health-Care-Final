package com.Sprint.HealthCareSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sprint.HealthCareSystem.Entity.User;
import com.Sprint.HealthCareSystem.Exceptions.UserCreationError;
import com.Sprint.HealthCareSystem.Exceptions.UserNotFound;
import com.Sprint.HealthCareSystem.Service.UserService;


@RestController
@RequestMapping("userdetails")
public class IUserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/validateUser")
	public User validateUser(@RequestBody User user) throws Exception {
		return userService.validateUser(user.getUsername(), user.getPassword());
	}

	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) throws UserCreationError {
		return userService.addUser(user);
	}

	@DeleteMapping("/removeuser")
	public User removeUser(@RequestBody User user) throws UserNotFound {
		return userService.removeUser(user);
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) throws UserNotFound {
		return userService.updateUser(user);

	}
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		return userService.getAll();
	}
	

}
