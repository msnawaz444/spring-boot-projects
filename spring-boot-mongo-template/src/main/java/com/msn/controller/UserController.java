package com.msn.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msn.dal.UserDAL;
import com.msn.model.User;
import com.msn.repo.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDAL userDAL;

	@PostMapping("/create")
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}

	@GetMapping("/")
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}

	// @RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
	// public Object getAllUserSettings(@PathVariable String userId) {
	// User user = userRepository.findOne(userId);
	// if (user != null) {
	// return user.getUserSettings();
	// } else {
	// return "User not found.";
	// }
	// }

	@GetMapping("/settings/{userId}")
	public Object getAllUserSettings(@PathVariable String userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			return userDAL.getAllUserSettings(userId);
		} else {
			return "User not found.";
		}
	}

	// @RequestMapping(value = "/settings/{userId}/{key}", method =
	// RequestMethod.GET)
	// public String getUserSetting(@PathVariable String userId, @PathVariable
	// String key) {
	// //User user = userRepository.findOne(userId);
	// String setting = userDAL.getUserSetting(userId, key);
	// LOG.info("Setting = "+setting);
	// if (setting != null) {
	// return setting;
	// } else {
	// return "Setting not found.";
	// }
	// }

	@GetMapping("/settings/{userId}/{key}")
	public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
		return userDAL.getUserSetting(userId, key);
	}

	@GetMapping("/settings/{userId}/{key}/{value}")
	public String addUserSetting(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			optionalUser.get().getUserSettings().put(key, value);
			userRepository.save(optionalUser.get());
			return "Key added";
		} else {
			return "User not found.";
		}
	}
}
