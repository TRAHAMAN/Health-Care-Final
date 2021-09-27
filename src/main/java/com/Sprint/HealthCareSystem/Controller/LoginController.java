package com.Sprint.HealthCareSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Sprint.HealthCareSystem.Entity.User;
import com.Sprint.HealthCareSystem.Exceptions.UserNotFound;
import com.Sprint.HealthCareSystem.loginmodule.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService logServ;

	@PostMapping("/Login")
	public User loginUser(@RequestBody User user) throws UserNotFound {
		return logServ.loginWithData(user.getUsername(), user.getPassword());
	}

	
	@PostMapping("/Logout")
	public User logOut(@RequestBody User user) throws UserNotFound {
			return logServ.logoutPresentUser(user.getUsername());
	}

}
