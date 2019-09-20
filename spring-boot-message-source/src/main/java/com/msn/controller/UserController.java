package com.msn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msn.message.source.Messages;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private Messages messages;

	@GetMapping
	public String getMesaageFromMessagePropertiesFile() {
		LOGGER.info(messages.getMessage("text")); // this does not return the value, only it can be used for printing on console
		return "Working fine";
	}
}
