package ui.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControllers {
	@GetMapping(path="/{userId}")
	public String getUser(@PathVariable String userId) {
		return "get user = " + userId;
	}
	@PostMapping()
	public String createUser() {
		return "create user";
	}
	@PutMapping
	public String updateUser() {
		return "update user";
	}
	@DeleteMapping
	public String deleteUser() {
		return "delete user";
	}
}
