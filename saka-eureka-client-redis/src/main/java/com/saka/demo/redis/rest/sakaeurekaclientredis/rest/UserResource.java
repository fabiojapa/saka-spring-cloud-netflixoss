package com.saka.demo.redis.rest.sakaeurekaclientredis.rest;

import com.saka.demo.redis.rest.sakaeurekaclientredis.model.User;
import com.saka.demo.redis.rest.sakaeurekaclientredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService userService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<User>> getUsers() {
    	final List<User> users = userService.findByPattern("*");
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<User> getUsers(@PathVariable("id") final String userId) {
    	final User user = userService.findById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> createUser(@RequestBody final User user) {
    	userService.save(user);
    	return new ResponseEntity<>(HttpStatus.CREATED);
	}

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> updateUser(@PathVariable("id") final String userId, @RequestBody final User user) {
    	user.setId(userId);
    	userService.update(user);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") final String userId) {
    	userService.delete(userId);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
