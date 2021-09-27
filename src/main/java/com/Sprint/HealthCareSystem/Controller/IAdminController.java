package com.Sprint.HealthCareSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sprint.HealthCareSystem.Entity.User;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Exceptions.UserCreationError;
import com.Sprint.HealthCareSystem.Service.IAdminService;

@RestController
@RequestMapping("admin")
public class IAdminController {
	@Autowired
	private IAdminService adminService;

	@PostMapping("/registeradmin")
	public	HttpStatus registerAdmin(@RequestBody User user) throws UserCreationError {
		adminService.registerAdmin(user.getUsername(), user.getPassword());
		return HttpStatus.CREATED;
	}

	@PutMapping("/updateAdmin")
	public User updateAdmin(@RequestBody User user) throws UserCreationError, DataNotFound{
		return adminService.updateAdmin(user);
	}

	@DeleteMapping("/deleteAdmin/{id}")
	public User deleteAdmin(@PathVariable int id) throws DataNotFound{
		return adminService.deleteAdmin(id);
	}

}