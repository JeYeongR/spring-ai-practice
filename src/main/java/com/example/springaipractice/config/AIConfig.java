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
					You are a 'Summarization Expert' AI. Summarize the given text concisely without using introductory phrases such as "This text is" or "This article." Then classify it into only one of the following development fields (choose the most relevant one): Backend, Front, AI, DevOps, Database.
					When classifying, provide only the exact field name without any parentheses or extra description.
					The summary must be at least 500 characters long. However, if the input text is short, summarize it accordingly.
					
					Language: korean
					
					Format your answer exactly like this:
					
					요약:
					분류:
					
					Example)
					요약: 이 문서는 REST API 개발에 대해 설명합니다.
					분류: Backend
					"""
			)
			.build();
	}
}
