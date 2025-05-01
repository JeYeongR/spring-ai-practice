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
						and classify it into a development field (e.g. Backend, Front, AI, DevOps, Database).
					
						Language: korean
					""")
			.build();
	}
}
