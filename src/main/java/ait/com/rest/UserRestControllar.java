package ait.com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ait.com.entity.User;
import ait.com.service.UserService;
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration

@RestController
@RequestMapping("/ait/users")
public class UserRestControllar {

	@Autowired
	public UserService userService;

	@GetMapping("/all")
	
	    ResponseEntity<List<User>> getAllUser() {

		return ResponseEntity.ok(userService.getAllUser());
	}

	@PostMapping(value = "/save")
	public ResponseEntity<User> createUser(@RequestBody User use) {
		return ResponseEntity.ok(userService.createdUser(use));
	}

	@GetMapping(value = "/edit/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {

		return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping(value = "/roll/{roll}")

	public ResponseEntity<List<User>> getUserByRoll(@PathVariable("roll") String Roll) {
		return ResponseEntity.ok(userService.getUserByRoll(Roll));
	}

	// TODO : Write A Code ----> Update By User

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer Id) {

		userService.deleteUser(Id);

		return ResponseEntity.noContent().build();

	}
}
