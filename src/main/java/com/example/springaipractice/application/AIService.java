package com.example.springaipractice.application;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {

	private final ChatClient chatClient;

	public AIService(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	public Map<String, String> generate(String userInput) {
		String content = this.chatClient.prompt().user(userInput).call().content();

		return Map.of("completion", content);
	}
}
