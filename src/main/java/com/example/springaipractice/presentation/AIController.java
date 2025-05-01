package com.example.springaipractice.presentation;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springaipractice.application.AIService;

@RestController
class AIController {

	private final AIService service;

	public AIController(AIService service) {
		this.service = service;
	}

	@PostMapping("/ai")
	public Map<String, String> generation(@RequestBody String userInput) {
		return service.generate(userInput);
	}
}
