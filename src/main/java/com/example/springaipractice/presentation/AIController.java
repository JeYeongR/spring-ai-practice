package com.example.springaipractice.presentation;

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

	// TODO: 응답값 맵핑하기, 기술 태그 추출가능하면 해보기
	@PostMapping("/ai")
	public AIResponseDto generation(@RequestBody AIRequestDto request) {
		return service.generate(request);
	}
}
