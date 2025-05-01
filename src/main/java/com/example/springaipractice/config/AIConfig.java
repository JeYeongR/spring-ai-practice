package com.example.springaipractice.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AIConfig {

	@Bean
	ChatClient chatClient(ChatClient.Builder builder) {
		return builder.defaultSystem(
				"""
					You are a 'Summarization Expert' AI.
					Your main task is to summarize the given text concisely
					and classify it into only one of the following development fields (choose the most relevant one): Backend, Front, AI, DevOps, Database.
					When classifying, provide only the exact field name without any parentheses or extra description.\s
					Language: korean
					"""
			)
			.build();
	}
}
